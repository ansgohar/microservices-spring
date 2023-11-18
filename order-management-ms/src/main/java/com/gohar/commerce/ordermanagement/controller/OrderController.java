package com.gohar.commerce.ordermanagement.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gohar.commerce.ordermanagement.dto.OrderDto;
import com.gohar.commerce.ordermanagement.dto.OrderItemDto;
import com.horussoft.healthcare.common.dto.ErrorResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/order", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class OrderController {

	@GetMapping("/test")
	public String sayHello() {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("", HttpStatus.ACCEPTED,
				"Hello SpringBoot developers!", LocalDateTime.now());
		return errorResponseDto.getErrorMessage();
	}

	
	@Operation(summary = "Fetch Order Details REST API", description = "REST API to fetch Order details based on a Order number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/mobile-number")
	public ResponseEntity<Collection<OrderDto>> fetchUserProfileDetailsByMobileNumber( @RequestParam String mobileNumber) {
		Collection<OrderItemDto> orderItems = new ArrayList<OrderItemDto>();
		orderItems.add(new OrderItemDto(1001l, 1l, 4l));
		orderItems.add(new OrderItemDto(1002l, 15l, 12l));
		orderItems.add(new OrderItemDto(1003l, 18l, 16l));
		OrderDto orderDto = new OrderDto(500001l, 1l, Long.valueOf("5"), (double) 10, 123.45, orderItems);
		
		Collection<OrderItemDto> orderItems2 = new ArrayList<OrderItemDto>();
		orderItems2.add(new OrderItemDto(2001l, 2l, 4l));
		orderItems2.add(new OrderItemDto(2002l, 12l, 20l));
		orderItems2.add(new OrderItemDto(2003l, 15l, 19l));
		OrderDto orderDto2 = new OrderDto(500001l, 1l, Long.valueOf("5"), (double) 10, 123.45, orderItems2);
		ArrayList<OrderDto> orderDtos = new ArrayList<OrderDto>();
		orderDtos.add(orderDto);
		orderDtos.add(orderDto2);
		return ResponseEntity.status(HttpStatus.OK).body(orderDtos);
	}


}
