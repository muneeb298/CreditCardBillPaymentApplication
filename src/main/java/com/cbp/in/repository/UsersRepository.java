package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{

}