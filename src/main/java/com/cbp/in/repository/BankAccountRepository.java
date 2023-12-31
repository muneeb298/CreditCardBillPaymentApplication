package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Account;

@Repository
public interface BankAccountRepository extends JpaRepository<Account, Long>{

}
