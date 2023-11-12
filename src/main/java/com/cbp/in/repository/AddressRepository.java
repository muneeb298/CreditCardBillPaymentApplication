package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
	

}
