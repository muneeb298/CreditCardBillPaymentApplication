package com.cbp.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbp.in.entity.Statement;


@Repository
public interface StatementRepository extends JpaRepository<Statement,Long> {
	
	Statement findById(long id);
}
