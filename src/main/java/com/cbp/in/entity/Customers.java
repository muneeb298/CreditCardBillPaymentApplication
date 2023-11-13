package com.cbp.in.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Customers {
	
	@Id
	private String customerId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users users;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<Address> addressList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private Set<CreditCard> creditCardList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<Transaction>  transactionList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<Statement>  statementList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Account> accountList;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Set<CreditCard> getCreditCardList() {
		return creditCardList;
	}

	public void setCreditCardList(Set<CreditCard> creditCardList) {
		this.creditCardList = creditCardList;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public List<Statement> getStatementList() {
		return statementList;
	}

	public void setStatementList(List<Statement> statementList) {
		this.statementList = statementList;
	}

	public Set<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}

	public Customers(String customerId, String name, String email, String contactNo, LocalDate dob, Users users,
			List<Address> addressList, Set<CreditCard> creditCardList, List<Transaction> transactionList,
			List<Statement> statementList, Set<Account> accountList) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.users = users;
		this.addressList = addressList;
		this.creditCardList = creditCardList;
		this.transactionList = transactionList;
		this.statementList = statementList;
		this.accountList = accountList;
	}
	
	public Customers() {
		
		
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo="
				+ contactNo + ", dob=" + dob + ", users=" + users + ", addressList=" + addressList + ", creditCardList="
				+ creditCardList + ", transactionList=" + transactionList + ", statementList=" + statementList
				+ ", accountList=" + accountList + "]";
	}
	
	
	
}
