package com.gohar.commerce.userprofile.service;

import java.util.Collection;

import com.gohar.commerce.userprofile.dto.UserPaymentDto;

public interface IUserPaymentService {

	void createUserPayment(UserPaymentDto paymentDto);

	UserPaymentDto fetchUserPayment(Long paymentId);
	
	Collection<UserPaymentDto> fetchUserPayments(Long userId);

	boolean updateUserPayment(UserPaymentDto paymentDto);

	boolean deleteUserPayment(String mobileNumber);
}
