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
@Table(name="user_address")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class UserAddress extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="address_id")
    private Long addressId;
    
    @Column(name="user_id")
    private Long userId;
    
    @Column(name="address")
    private String address;

    @Column(name="address2")
    private String address2;
    
    @Column(name="district")
    private String district;

    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="postal_code")
    private String postalCode;
   
    
}
