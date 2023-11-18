package com.gohar.commerce.userprofile.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gohar.commerce.userprofile.entity.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

	Collection<UserAddress> findByUserId(Long userId);


}
