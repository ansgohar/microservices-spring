package com.gohar.commerce.userprofile.dto;

import com.horussoft.healthcare.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDto extends BaseEntity {

	private Long addressId;
	private String address;
	private String address2;
	private String district;
	private String city;
	private String state;
	private String postalCode;

}
