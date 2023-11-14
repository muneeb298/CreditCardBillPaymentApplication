package com.cbp.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address {
		@Id
		@SequenceGenerator(allocationSize=1,initialValue=400001,name= "add_seq")
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="add_seq")
		@Column(name="Door_Number")
		@NotNull(message="Door number cannot be null")
		@NotBlank(message="Please enter valid door number ")
		private String doorNo;
		@Column(name="Street_Name")
		@NotNull(message="Street name cannot be null")
		@NotBlank(message="Please enter valid street name")
		private String street;

		@Column(name="Area_Name")
		@NotNull(message="Area name cannot be null")
		@NotBlank(message="Please enter valid area name")
		private String area;

		@Column(name="City_Name")
		@NotNull(message="City name cannot be null")
		@NotBlank(message="Please enter valid city name")
		private String city;
		@Column(name="State_Name")
		@NotNull(message="State name cannot be null")
		@NotBlank(message="Please enter valid state name")
		private String state;
		@Column(name="Pincode")
		private int pincode;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="customerId")
		@JsonIgnore
		private Customers customers;
		public Address() {
	 
		super();
		}
		public Address(
			@NotBlank(message="Please enter valid door number ")@NotNull(message="Door number cannot be null") String doorNo,
			@NotNull(message="Street name cannot be null")@NotBlank(message="Please enter valid street name") String street,
			@NotNull(message="Area name cannot be null")@NotBlank(message="Please enter valid area name") String area,
			@NotNull(message="City name cannot be null")@NotBlank(message="Please enter valid city name") String city,
			@NotNull(message="State name cannot be null")@NotBlank(message="Please enter valid state name") String state,
			int pincode){
	 
	        super();
			this.doorNo=doorNo;
			this.street=street;
			this.area=area;
			this.city=city;
			this.state=state;
			this.pincode=pincode;
		}
		public String getDoorNo() {
			return doorNo;
		}
		public void setDoorNo(String doorNo) {
			this.doorNo = doorNo;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
	 
		@Override
		public String toString() {
			return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
					+ state + ", pincode=" + pincode + "]";
		}
}

