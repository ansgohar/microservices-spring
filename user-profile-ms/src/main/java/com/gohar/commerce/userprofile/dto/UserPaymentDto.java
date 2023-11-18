package com.gohar.commerce.userprofile.dto;

import com.horussoft.healthcare.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentDto extends BaseEntity {

	private Long paymentId;
	private String paymentType;
	private String provider;
	private String accountNumber;

}
