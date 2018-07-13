package com.niit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity

public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * private property field
	 */ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/*------------------------*/
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*-------------------------------*/	
	@Column(name="address_line_one")
	@NotBlank(message="Please enter address line one!")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message="Please enter address line two!")
	private String addressLineTwo;
	
	@NotBlank(message="Please enter city!")
	private String city;
	
	@NotBlank(message="Please enter state!")
	private String state;
	
	@NotBlank(message="Please enter country!")
	private String country;
	
	@NotBlank(message="Please enter PIN code!")
	@Column(name="postal_code")
	private String postalCode;
	
	private boolean shipping;
	private boolean billing;
	
	// toString() method	
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	//Getter and setter	
	
	
	public int getId() {
		return id;
	}		

	public void setId(int id) {
		this.id = id;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}	
	
}


