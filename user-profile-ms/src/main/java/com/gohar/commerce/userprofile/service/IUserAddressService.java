package com.gohar.commerce.userprofile.service;

import java.util.Collection;

import com.gohar.commerce.userprofile.dto.UserAddressDto;

public interface IUserAddressService {

	void createUserAddress(UserAddressDto addressDto);

	UserAddressDto fetchUserAddress(Long addressId);
	
	Collection<UserAddressDto> fetchUserAddresses(Long userId);

	boolean updateUserAddress(UserAddressDto addressDto);

	boolean deleteUserAddress(String mobileNumber);
}
