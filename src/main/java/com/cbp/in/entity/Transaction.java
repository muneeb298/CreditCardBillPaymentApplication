package com.cbp.in.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transId;
	@NotBlank(message="cardNumber can't be blank")
	@Column(name="CardNumber")
	private String cardNumber;
	private LocalDate tranDate;
	@NotEmpty(message = "status should not be empty")
	private String status;
	
	private double amount;
	@NotEmpty(message = "paymentMethod should not be empty")
	private String paymentMethod;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customers customers;
 
	public long getTransId() {
		return transId;
	}
 
	public void setTransId(long transId) {
		this.transId = transId;
	}
 
	public String getCardNumber() {
		return cardNumber;
	}
 
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
 
	public LocalDate getTranDate() {
		return tranDate;
	}
 
	public void setTranDate(LocalDate tranDate) {
		this.tranDate = tranDate;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	public double getAmount() {
		return amount;
	}
 
	public void setAmount(double amount) {
		this.amount = amount;
	}
 
	public String getPaymentMethod() {
		return paymentMethod;
	}
 
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
 
	public Customers getCustomers() {
		return customers;
	}
 
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
 
	public Transaction(long transId, @NotBlank(message = "cardNumber can't be blank") String cardNumber,
			LocalDate tranDate, String status, double amount, String paymentMethod, String description,
			Customers customers) {
		super();
		this.transId = transId;
		this.cardNumber = cardNumber;
		this.tranDate = tranDate;
		this.status = status;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.customers = customers;
	}

	public Transaction() {

	}
 
	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", cardNumber=" + cardNumber + ", tranDate=" + tranDate + ", status="
				+ status + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", description=" + description
				+  "]";
	}

	
	
}