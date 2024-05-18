package com.galvix.galvixassessment.dto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("order_datetime")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX")
	private ZonedDateTime orderDatetime;
	private Customer customer;
	private List<Item> items;
	@JsonProperty("shipping_price")
	private double shippingPrice;
	private List<Discount> discounts;

	public Order() {
	}

	public Order(String orderId, ZonedDateTime orderDatetime, Customer customer, List<Item> items, double shippingPrice,
			List<Discount> discounts) {
		this.orderId = orderId;
		this.orderDatetime = orderDatetime;
		this.customer = customer;
		this.items = items;
		this.shippingPrice = shippingPrice;
		this.discounts = discounts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public ZonedDateTime getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(ZonedDateTime orderDatetime) {
		this.orderDatetime = orderDatetime;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]").add("orderId='" + orderId + "'")
				.add("orderDatetime=" + orderDatetime).add("customer=" + customer).add("items=" + items)
				.add("shippingPrice=" + shippingPrice).add("discounts=" + discounts).toString();
	}
}
