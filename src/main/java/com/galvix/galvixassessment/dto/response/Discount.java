package com.galvix.galvixassessment.dto.response;

import java.util.StringJoiner;

public class Discount {
	private String type;
	private double value;

	public Discount() {
	}

	public Discount(String type, double value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Discount.class.getSimpleName() + "[", "]").add("type='" + type + "'")
				.add("value=" + value).toString();
	}
}
