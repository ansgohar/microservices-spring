package com.gohar.commerce.userprofile.mapper;

import com.gohar.commerce.userprofile.dto.CustomerDetailsDto;
import com.gohar.commerce.userprofile.dto.UserAddressDto;
import com.gohar.commerce.userprofile.dto.UserDto;
import com.gohar.commerce.userprofile.dto.UserPaymentDto;
import com.gohar.commerce.userprofile.entity.User;
import com.gohar.commerce.userprofile.entity.UserAddress;
import com.gohar.commerce.userprofile.entity.UserPayment;

public class UserMapper {

	private UserMapper () {
		
	}
	public static UserDto mapToUserDto(User user, UserDto userDto) {
		userDto.setUserId(user.getUserId());
		userDto.setName(user.getName());
		userDto.setMobileNumber(user.getMobileNumber());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	public static User mapToUser(UserDto userDto, User user) {
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
		return user;
	}

	public static UserAddressDto mapToUserAddressDto(UserAddress address, UserAddressDto addressDto) {
		addressDto.setAddress(address.getAddress());
		addressDto.setAddress2(address.getAddress2());
		addressDto.setCity(address.getCity());
		addressDto.setDistrict(address.getDistrict());
		addressDto.setPostalCode(address.getPostalCode());
		addressDto.setState(address.getState());

		return addressDto;
	}

	public static UserAddress mapToUserAddress(UserAddressDto addressDto, UserAddress address) {
		address.setAddress(addressDto.getAddress());
		address.setAddress2(addressDto.getAddress2());
		address.setCity(addressDto.getCity());
		address.setDistrict(addressDto.getDistrict());
		address.setPostalCode(addressDto.getPostalCode());
		address.setState(addressDto.getState());
		return address;
	}

	public static UserPaymentDto mapToUserPaymentDto(UserPayment payment, UserPaymentDto paymentDto) {
		paymentDto.setAccountNumber(payment.getAccountNumber());
		paymentDto.setPaymentType(payment.getPaymentType());
		paymentDto.setProvider(payment.getProvider());
		return paymentDto;
	}

	public static UserPayment mapToUserPayment(UserPaymentDto paymentDto, UserPayment payment) {
		payment.setAccountNumber(paymentDto.getAccountNumber());
		payment.setPaymentType(paymentDto.getPaymentType());
		payment.setProvider(paymentDto.getProvider());
		return payment;
	}

	public static CustomerDetailsDto mapToCustomerDetailsDto(User user, CustomerDetailsDto customerDetailsDto) {
		customerDetailsDto.setUserId(user.getUserId());
		customerDetailsDto.setName(user.getName());
		customerDetailsDto.setMobileNumber(user.getMobileNumber());
		customerDetailsDto.setEmail(user.getEmail());
		return customerDetailsDto;
	}

	public static User mapToUser(CustomerDetailsDto customerDetailsDto, User user) {
		user.setUserId(customerDetailsDto.getUserId());
		user.setName(customerDetailsDto.getName());
		user.setMobileNumber(customerDetailsDto.getMobileNumber());
		user.setEmail(customerDetailsDto.getEmail());
		return user;
	}
	
}
