package com.gohar.commerce.userprofile.service.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gohar.commerce.userprofile.dto.OrderDto;
import com.horussoft.healthcare.common.service.client.CardsFallback;

@FeignClient(name = "order-management-ms", fallback = CardsFallback.class)
public interface OrderManagementFeingnClient {

	@GetMapping(value = "/api/order/mobile-number", consumes = "application/json")
	public ResponseEntity<Collection<OrderDto>> fetchUserProfileDetailsByMobileNumber(
			@RequestParam String mobileNumber);

}
