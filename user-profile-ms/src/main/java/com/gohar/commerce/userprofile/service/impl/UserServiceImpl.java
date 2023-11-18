package com.gohar.commerce.userprofile.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gohar.commerce.userprofile.constant.UserConstants;
import com.gohar.commerce.userprofile.dto.UserAddressDto;
import com.gohar.commerce.userprofile.dto.UserDto;
import com.gohar.commerce.userprofile.dto.UserPaymentDto;
import com.gohar.commerce.userprofile.entity.User;
import com.gohar.commerce.userprofile.entity.UserAddress;
import com.gohar.commerce.userprofile.entity.UserPayment;
import com.gohar.commerce.userprofile.exception.UserAlreadyExistsException;
import com.gohar.commerce.userprofile.mapper.UserMapper;
import com.gohar.commerce.userprofile.repository.UserAddressRepository;
import com.gohar.commerce.userprofile.repository.UserPaymentRepository;
import com.gohar.commerce.userprofile.repository.UserRepository;
import com.gohar.commerce.userprofile.service.IUserService;
import com.horussoft.healthcare.common.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
	private UserRepository userRepository;
	private UserAddressRepository addressRepository;
	private UserPaymentRepository paymentRepository;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public void createUser(UserDto userDto) {
		User user = UserMapper.mapToUser(userDto, new User());
		Optional<User> optionalUser = userRepository.findByMobileNumber(userDto.getMobileNumber());
		if (optionalUser.isPresent()) {
			throw new UserAlreadyExistsException(
					"User already registered with given mobileNumber " + userDto.getMobileNumber());
		}
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy(UserConstants.SYSTEM_USER);
		User savedUser = userRepository.save(user);
		Collection<UserAddressDto> addressDtos = userDto.getAddressDtos();
		if (null != addressDtos && !addressDtos.isEmpty()) {
			for (UserAddressDto addressDto : addressDtos) {
				UserAddress userAddress = UserMapper.mapToUserAddress(addressDto, new UserAddress());
				userAddress.setUserId(savedUser.getUserId());
				userAddress.setCreatedAt(LocalDateTime.now());
				userAddress.setCreatedBy(UserConstants.SYSTEM_USER);
				addressRepository.save(userAddress);
			}
		}

		Collection<UserPaymentDto> paymantDtos = userDto.getPaymantDtos();

		if (null != paymantDtos && !paymantDtos.isEmpty()) {
			for (UserPaymentDto paymentDto : paymantDtos) {
				UserPayment payment = UserMapper.mapToUserPayment(paymentDto, new UserPayment());
				payment.setUserId(savedUser.getUserId());
				payment.setCreatedAt(LocalDateTime.now());
				payment.setCreatedBy(UserConstants.SYSTEM_USER);
				paymentRepository.save(payment);
			}
		}
	}

	@Override
	public UserDto fetchUser(String mobileNumber) {
		User user = userRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

		return UserMapper.mapToUserDto(user, new UserDto());
	}

	@Override
	public UserDto fetchUserInfo(String mobileNumber) {
		User user = userRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		logger.info("user.getUserId() : {}", user.getUserId());

		Collection<UserAddress> userAddresses = addressRepository.findByUserId(user.getUserId());
		Collection<UserPayment> userPayments = paymentRepository.findByUserId(user.getUserId());
		UserDto userDto = UserMapper.mapToUserDto(user, new UserDto());
		logger.info("userAddresses : {}", userAddresses);
		if (!userAddresses.isEmpty()) {
			userDto.setAddressDtos(new ArrayList<>());
			userAddresses.forEach(address -> userDto.getAddressDtos()
					.add(UserMapper.mapToUserAddressDto(address, new UserAddressDto())));
		}

		logger.info("userPayments : {}", userPayments);
		if (!userPayments.isEmpty()) {
			userDto.setPaymantDtos(new ArrayList<>());
			userPayments.forEach(payment -> userDto.getPaymantDtos()
					.add(UserMapper.mapToUserPaymentDto(payment, new UserPaymentDto())));
		}

		return userDto;
	}

	@Override
	public boolean updateUser(UserDto userDto) {
		boolean isUpdated = false;
		User user = userRepository.findById(userDto.getUserId()).orElseThrow(
				() -> new ResourceNotFoundException("User", "UserID", String.valueOf(userDto.getUserId())));
		logger.info("user.getUserId() : {}", user.getUserId());

		userRepository.save(user);

		Collection<UserAddress> userAddresses = addressRepository.findByUserId(user.getUserId());
		addressRepository.saveAll(userAddresses);
		Collection<UserPayment> userPayments = paymentRepository.findByUserId(user.getUserId());
		paymentRepository.saveAll(userPayments);

		return isUpdated;
	}

	@Override
	public boolean deleteUser(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserID", String.valueOf(userId)));
		userRepository.deleteById(user.getUserId());
		return true;
	}

}
