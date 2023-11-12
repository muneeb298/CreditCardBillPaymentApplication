package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.Statement;

public interface StatementService {
	
	public Statement addStatement(Statement statement);
	
		public Statement removeStatement(long id);
		 
		public Statement updateStatement(long id, Statement statement);

		public Statement getStatement(long id);

		public List<Statement> getAllStatements();

		public Statement getBilledStatement(long id);

		public Statement getUnbilledStatement(long id);

}
