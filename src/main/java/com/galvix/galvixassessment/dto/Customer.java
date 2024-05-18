package com.galvix.galvixassessment.dto;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	private String id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	private String email;
	private String phone;
	@JsonProperty("shipping_address")
	private Address shippingAddress;

	public Customer() {
	}

	public Customer(String id, String firstName, String lastName, String email, String phone, Address shippingAddress) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.shippingAddress = shippingAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]").add("id='" + id + "'")
				.add("firstName='" + firstName + "'").add("lastName='" + lastName + "'").add("email='" + email + "'")
				.add("phone='" + phone + "'").add("shippingAddress=" + shippingAddress).toString();
	}
}
