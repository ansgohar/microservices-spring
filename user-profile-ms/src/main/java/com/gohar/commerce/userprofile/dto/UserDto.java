package com.gohar.commerce.userprofile.dto;

import java.util.Collection;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "UserDto", description = "Schema to User information")
public class UserDto {

	@Schema(description = "User Identified code")
	private Long userId;
	@Schema(description = "User Name")
	@NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the name should be between 5 and 30")
	private String name;
	@Schema(description = "User Email")
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
	private String email;
	@Schema(description = "User Mobile Number")
	@Pattern(regexp = "(^$|\\d{10})", message = "Mobile number must be 10 digits")
	private String mobileNumber;
	@Schema(description = "Collection of User Address(es)")
	private Collection<UserAddressDto> addressDtos;
	@Schema(description = "Collection of User Payment(s)")
	private Collection<UserPaymentDto> paymantDtos;
	

}
