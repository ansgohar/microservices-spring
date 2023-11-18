package com.gohar.commerce.userprofile.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gohar.commerce.userprofile.entity.UserPayment;

@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

	Collection<UserPayment> findByUserId(Long userId);


}
