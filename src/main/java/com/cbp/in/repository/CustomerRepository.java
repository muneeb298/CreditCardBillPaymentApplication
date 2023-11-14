package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>{

}
