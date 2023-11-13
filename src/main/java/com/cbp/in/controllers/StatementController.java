package com.cbp.in.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.Statement;
import com.cbp.in.service.StatementService;


@RestController
@RequestMapping("/statementapi")
public class StatementController {
	
	@Autowired
	StatementService statementservice;
	
	@PostMapping("/addstatement")
	public Statement addStatement(@RequestBody Statement statement) {
		return statementservice.addStatement(statement);
	}
	
	@GetMapping("/removestatement/{id}")
	public Statement removeStatement(@PathVariable("id")long pid) {
		return statementservice.removeStatement(pid);
	}
	
	@PutMapping("/updatestatement/{id}")
	public Statement updateStatement(@PathVariable("id")long id, @RequestBody Statement statement){
		return statementservice.updateStatement(id, statement);
	}

	@GetMapping("/getstatement/{id}")
	public Statement getStatement(@PathVariable("id") long id) {
		return statementservice.getStatement(id);
	}
	
	@GetMapping("/getallstatements")
	public List<Statement> getAllStatements()
	{
		return statementservice.getAllStatements();
	}
	@GetMapping("/getbilledstatement/{id}")
	public Statement getBilledStatements(@PathVariable("id") long id) {
		return statementservice.getBilledStatement(id);
	}
	
	@GetMapping("/getunbilledstatement/{id}")
	public Statement getUnbilledStatements(@PathVariable("id") long id){
		return statementservice.getUnbilledStatement(id);
	}
}
