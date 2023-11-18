package com.gohar.commerce.userprofile.service;

import com.gohar.commerce.userprofile.dto.UserDto;

public interface IUserService {

	void createUser(UserDto userDto);

	UserDto fetchUser(String mobileNumber);

	UserDto fetchUserInfo(String mobileNumber);

	boolean updateUser(UserDto userDto);

	boolean deleteUser(Long userId);

}
