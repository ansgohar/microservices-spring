package com.gohar.commerce.userprofile.entity;

import com.horussoft.healthcare.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_payment")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserPayment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "payment_type")
	private String paymentType;

	@Column(name = "provider")
	private String provider;

	@Column(name = "account_number")
	private String accountNumber;

}
