package com.cbp.in.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statement {
	@Id
	private long statementId;
	private double dueAmmount;
	private LocalDate billingDate;
	private LocalDate dueDate;
	@ManyToOne
	private Customers customers;

	public long getStatementId() {
		return statementId;
	}

	public void setStatementId(long statementId) {
		this.statementId = statementId;
	}

	public double getDueAmmount() {
		return dueAmmount;
	}

	public void setDueAmmount(double dueAmmount) {
		this.dueAmmount = dueAmmount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Statement(long statementId, double dueAmmount, LocalDate billingDate, LocalDate dueDate,
			Customers customers) {
		super();
		this.statementId = statementId;
		this.dueAmmount = dueAmmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", dueAmmount=" + dueAmmount + ", billingDate=" + billingDate
				+ ", dueDate=" + dueDate + ", customers=" + customers + "]";
	}

	public Statement() {

	}

}
