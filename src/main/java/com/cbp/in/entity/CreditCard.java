package com.cbp.in.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class CreditCard {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public long creditId;
	@NotBlank(message="CardName can't be blank")
	public String cardname;
	public String cardtype;
	@NotBlank(message="CardNumber can't be Null")
	public String cardnumber;
	public LocalDate expirydate;
	public String bankname;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	@JsonIgnore
	public Customers customers;
 
	public CreditCard() {
	}
	public long getCreditId() {
		return creditId;
	}
	public void setCreditId(long creditId) {
		this.creditId = creditId;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public LocalDate getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	@Override
	public String toString() {
		return "CreditCard [creditId=" + creditId + ", cardname=" + cardname + ", cardtype=" + cardtype
				+ ", cardnumber=" + cardnumber + ", expirydate=" + expirydate + ", bankname=" + bankname + "]";
	}
	public CreditCard(long creditId, @NotBlank(message = "CardName can't be blank") String cardname, String cardtype,
			@NotBlank(message = "CardNumber can't be Null") String cardnumber, LocalDate expirydate, String bankname) {
		super();
		this.creditId = creditId;
		this.cardname = cardname;
		this.cardtype = cardtype;
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.bankname = bankname;
	}

	 
	}
