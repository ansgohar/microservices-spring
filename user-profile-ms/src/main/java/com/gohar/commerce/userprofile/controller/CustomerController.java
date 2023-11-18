package com.gohar.commerce.userprofile.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gohar.commerce.userprofile.dto.CustomerDetailsDto;
import com.gohar.commerce.userprofile.service.ICustomerService;
import com.horussoft.healthcare.common.dto.ErrorResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;

@Tag(name = "REST API for Customer Controller", description = "REST API for Customer to FETCH Customer details")
@RestController
@RequestMapping(path = "/api/customer", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class CustomerController {

	private final ICustomerService iCustomerService;

	
	public CustomerController(ICustomerService iCustomerService) {
		this.iCustomerService = iCustomerService;
	}

	@Operation(summary = "Fetch Customer Details  REST API", description = "REST API to fetch User Customer details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/fetch-details")
	public ResponseEntity<CustomerDetailsDto> fetchUserProfileDetails(
			@RequestParam @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		CustomerDetailsDto  customerDetailsDto = iCustomerService.fetchCustomerInfo(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
	}

}
