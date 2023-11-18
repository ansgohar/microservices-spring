package com.gohar.commerce.userprofile.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gohar.commerce.userprofile.constant.UserConstants;
import com.gohar.commerce.userprofile.dto.ApplicationContactInfoDto;
import com.gohar.commerce.userprofile.dto.UserDto;
import com.gohar.commerce.userprofile.service.IUserService;
import com.horussoft.healthcare.common.dto.ErrorResponseDto;
import com.horussoft.healthcare.common.dto.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(path = "/api/user", produces = { MediaType.APPLICATION_JSON_VALUE })
@Validated
public class UserController {

	public UserController(IUserService iUserService, Environment environment) {
		this.iUserService = iUserService;
		this.environment = environment;
	}

	private final IUserService iUserService;
	private Environment environment;

//	@Value("${build.version}")
//	private String buildVersion;

	@Autowired
	private ApplicationContactInfoDto applicationContactInfoDto;

	@GetMapping("/test")
	public String sayHello() {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto("", HttpStatus.ACCEPTED,
				"Hello SpringBoot developers!", LocalDateTime.now());
		return errorResponseDto.getErrorMessage();
	}

//    @RateLimiter(name= "getJavaVersion", fallbackMethod = "getJavaVersionFallback")
	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body("JAVA_HOME is: " + environment.getProperty("JAVA_HOME"));
	}

//    @Retry(name = "getBuildInfo",fallbackMethod = "getBuildInfoFallback")
//	@GetMapping("/build-info")
//	public ResponseEntity<String> getBuildInfo() {
//		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
//	}

	@GetMapping("/contact-info")
	public ResponseEntity<ApplicationContactInfoDto> getContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(applicationContactInfoDto);
	}

	@Operation(summary = "Create User REST API", description = "REST API to create new User")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PostMapping()
	public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody UserDto userDto) {
		iUserService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
	}

	@Operation(summary = "Fetch User Details REST API", description = "REST API to fetch User details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("")
	public ResponseEntity<UserDto> fetchUserDetails(
			@RequestParam @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		UserDto userDto = iUserService.fetchUser(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}

	@Operation(summary = "Fetch User Profile Details REST API", description = "REST API to fetch User Profile details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/fetch")
	public ResponseEntity<UserDto> fetchUserProfileDetails(
			@RequestParam @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		UserDto userDto = iUserService.fetchUserInfo(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
	}

	@Operation(summary = "Update User Details REST API", description = "REST API to update User details based on a account number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PutMapping("")
	public ResponseEntity<ResponseDto> updateUserDetails(@Valid @RequestBody UserDto userDto) {
		boolean isUpdated = iUserService.updateUser(userDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(UserConstants.STATUS_417, UserConstants.MESSAGE_417_UPDATE));
		}
	}

	@Operation(summary = "Delete User Details REST API", description = "REST API to delete User details based on a userID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@DeleteMapping("")
	public ResponseEntity<ResponseDto> deleteUserDetails(
			@RequestParam @Pattern(regexp = "(^$|\\d)", message = "User must be digits") Long userId) {
		boolean isDeleted = iUserService.deleteUser(userId);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(UserConstants.STATUS_417, UserConstants.MESSAGE_417_DELETE));
		}
	}

}
