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
public class CreditCard {

	
		@Id
		private Long id;
		private String cardName;
		private String cardType;
		private String cardNumber;
		private LocalDate expiryDate;
		private String bankName;
		@ManyToOne
		private Customers customers;
		public CreditCard() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CreditCard(Long id, String cardName, String cardType, String cardNumber, LocalDate expiryDate,
				String bankName, Customers customers) {
			super();
			this.id = id;
			this.cardName = cardName;
			this.cardType = cardType;
			this.cardNumber = cardNumber;
			this.expiryDate = expiryDate;
			this.bankName = bankName;
			this.customers = customers;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCardName() {
			return cardName;
		}
		public void setCardName(String cardName) {
			this.cardName = cardName;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public LocalDate getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(LocalDate expiryDate) {
			this.expiryDate = expiryDate;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public Customers getCustomers() {
			return customers;
		}
		public void setCustomers(Customers customers) {
			this.customers = customers;
		}
		@Override
		public String toString() {
			return "CreditCard [id=" + id + ", cardName=" + cardName + ", cardType=" + cardType + ", cardNumber="
					+ cardNumber + ", expiryDate=" + expiryDate + ", bankName=" + bankName + ", customers=" + customers
					+ "]";
		}
		

	 
	}
