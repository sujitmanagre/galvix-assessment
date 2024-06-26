package com.galvix.galvixassessment.dto;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	private int quantity;
	@JsonProperty("unit_price")
	private double unitPrice;
	private Product product;

	public Item() {
	}

	public Item(int quantity, double unitPrice, Product product) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]").add("quantity=" + quantity)
				.add("unitPrice=" + unitPrice).add("product=" + product).toString();
	}
}
