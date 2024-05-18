package com.galvix.galvixassessment.dto.response;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("product_id")
	private String productId;
	private String title;
	private String image;
	private String upc;
	@JsonProperty("created_at")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX")
	private ZonedDateTime createdAt;
	private Brand brand;

	public Product() {
	}

	public Product(String productId, String title, String image, String upc, ZonedDateTime createdAt, Brand brand) {
		this.productId = productId;
		this.title = title;
		this.image = image;
		this.upc = upc;
		this.createdAt = createdAt;
		this.brand = brand;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]").add("productId='" + productId + "'")
				.add("title='" + title + "'").add("image='" + image + "'").add("upc='" + upc + "'")
				.add("createdAt=" + createdAt).add("brand=" + brand).toString();
	}
}
