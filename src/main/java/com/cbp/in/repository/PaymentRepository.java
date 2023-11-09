package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
