package com.galvix.galvixassessment.dto.response;

import java.util.StringJoiner;

public class Address {
	private String street;
	private String postcode;
	private String suburb;
	private String state;

	public Address() {
	}

	public Address(String street, String postcode, String suburb, String state) {
		this.street = street;
		this.postcode = postcode;
		this.suburb = suburb;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]").add("street='" + street + "'")
				.add("postcode='" + postcode + "'").add("suburb='" + suburb + "'").add("state='" + state + "'")
				.toString();
	}
}
