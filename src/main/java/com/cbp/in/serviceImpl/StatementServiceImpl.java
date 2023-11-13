package com.cbp.in.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Statement;
import com.cbp.in.exceptions.StatementNotFoundException;
import com.cbp.in.repository.StatementRepository;
import com.cbp.in.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	StatementRepository statementrepository;

	@Override
	public Statement addStatement(Statement statement) {
		
		statementrepository.save(statement);
		
		return statement;
	}

	@Override
	public Statement removeStatement(long id) {
		
		if (statementrepository.existsById(id)) {
			
			Statement s = statementrepository.findById(id);
			
			statementrepository.deleteById(id);
			
			return s;
			
		} else {
			
			throw new StatementNotFoundException("Statement Not Found");
		}
	}

	@Override
	public Statement updateStatement(long id, Statement statement) {
		
		if (statementrepository.existsById(id)) {
			
			return statementrepository.save(statement);
			
		} else {
			
			throw new StatementNotFoundException("Statement Not Found");
		}
	}

	@Override
	public Statement getStatement(long id) {
		
		if (statementrepository.existsById(id)) {
			
			return statementrepository.findById(id);
			
		} else {
			
			throw new StatementNotFoundException("Statement Not Found");
		}
	}

	@Override
	public List<Statement> getAllStatements() {
		
		return statementrepository.findAll();
	}

	@Override
	public Statement getBilledStatement(long id) {
		
		Statement billedStatement = statementrepository.findById(id);
		
		if (billedStatement != null && billedStatement.getDueAmount() > 0) {
			
			Statement statement = new Statement();
			
			statement.setStatementId(billedStatement.getStatementId());
			
			statement.setDueAmount(billedStatement.getDueAmount());
			
			statement.setBillingDate(billedStatement.getBillingDate());
			
			statement.setDueDate(billedStatement.getDueDate());
			
			// statement.setCustomer(billedStatement.getCustomer());
			
			return statement;
			
		} else {
			
			throw new StatementNotFoundException("Statement not found with the given id");
		}
	}

	@Override
	public Statement getUnbilledStatement(long id) {
		
		Statement unbilledStatement = statementrepository.findById(id);
		
		if (unbilledStatement != null && unbilledStatement.getDueAmount() == 0) {
			
			Statement statement = new Statement();
			
			statement.setStatementId(unbilledStatement.getStatementId());
			
			statement.setDueAmount(unbilledStatement.getDueAmount());
			
			statement.setBillingDate(unbilledStatement.getBillingDate());
			
			statement.setDueDate(unbilledStatement.getDueDate());
			
			// statement.setCustomer(unbilledStatement.getCustomer());
			
			return statement;
			
		} else {
			
			throw new StatementNotFoundException("Statement not found with the given id");
		}
	}

}
