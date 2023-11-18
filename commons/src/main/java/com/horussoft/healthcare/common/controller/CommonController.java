package com.horussoft.healthcare.common.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horussoft.healthcare.common.dto.ErrorResponseDto;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CommonController {
	@GetMapping("/test")
	public String sayHello() {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("", HttpStatus.ACCEPTED, "Hello SpringBoot developers!", LocalDateTime.now());
		return errorResponseDto.getErrorMessage();
	}

}
