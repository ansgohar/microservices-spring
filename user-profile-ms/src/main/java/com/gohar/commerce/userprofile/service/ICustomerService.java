package com.gohar.commerce.userprofile.service;

import com.gohar.commerce.userprofile.dto.CustomerDetailsDto;

public interface ICustomerService {

	CustomerDetailsDto fetchCustomerInfo(String mobileNumber);

}
