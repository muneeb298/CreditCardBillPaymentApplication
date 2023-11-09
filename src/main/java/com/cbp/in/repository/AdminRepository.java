package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

}
