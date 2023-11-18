package com.gohar.commerce.userprofile.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gohar.commerce.userprofile.dto.CustomerDetailsDto;
import com.gohar.commerce.userprofile.dto.OrderDto;
import com.gohar.commerce.userprofile.dto.UserAddressDto;
import com.gohar.commerce.userprofile.dto.UserPaymentDto;
import com.gohar.commerce.userprofile.entity.User;
import com.gohar.commerce.userprofile.entity.UserAddress;
import com.gohar.commerce.userprofile.entity.UserPayment;
import com.gohar.commerce.userprofile.mapper.UserMapper;
import com.gohar.commerce.userprofile.repository.UserAddressRepository;
import com.gohar.commerce.userprofile.repository.UserPaymentRepository;
import com.gohar.commerce.userprofile.repository.UserRepository;
import com.gohar.commerce.userprofile.service.ICustomerService;
import com.gohar.commerce.userprofile.service.client.OrderManagementFeingnClient;
import com.horussoft.healthcare.common.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
	private UserRepository userRepository;
	private UserAddressRepository addressRepository;
	private UserPaymentRepository paymentRepository;
	private OrderManagementFeingnClient orderManagementFeingnClient;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	
	

	@Override
	public CustomerDetailsDto fetchCustomerInfo(String mobileNumber) {
		User user = userRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		logger.info("user.getUserId() : {}", user.getUserId());

		CustomerDetailsDto customerDetailsDto = UserMapper.mapToCustomerDetailsDto(user, new CustomerDetailsDto());
		
		Collection<UserAddress> userAddresses = addressRepository.findByUserId(user.getUserId());
		logger.info("userAddresses : {}", userAddresses);
		if (!userAddresses.isEmpty()) {
			customerDetailsDto.setAddressDtos(new ArrayList<>());
			userAddresses.forEach(address -> customerDetailsDto.getAddressDtos()
					.add(UserMapper.mapToUserAddressDto(address, new UserAddressDto())));
		}
		
		Collection<UserPayment> userPayments = paymentRepository.findByUserId(user.getUserId());
		logger.info("userPayments : {}", userPayments);
		if (!userPayments.isEmpty()) {
			customerDetailsDto.setPaymantDtos(new ArrayList<>());
			userPayments.forEach(payment -> customerDetailsDto.getPaymantDtos()
					.add(UserMapper.mapToUserPaymentDto(payment, new UserPaymentDto())));
		}

		Collection<OrderDto> orderDtos=	orderManagementFeingnClient.fetchUserProfileDetailsByMobileNumber(mobileNumber).getBody();
		customerDetailsDto.setOrderDtos(orderDtos);
		return customerDetailsDto;
	}

	

}
