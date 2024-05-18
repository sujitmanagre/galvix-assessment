package com.galvix.galvixassessment.dto.response;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brand {
	@JsonProperty("brand_id")
	private String brandId;
	private String name;

	public Brand() {
	}

	public Brand(String brandId, String name) {
		this.brandId = brandId;
		this.name = name;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Brand.class.getSimpleName() + "[", "]").add("brandId='" + brandId + "'")
				.add("name='" + name + "'").toString();
	}
}
