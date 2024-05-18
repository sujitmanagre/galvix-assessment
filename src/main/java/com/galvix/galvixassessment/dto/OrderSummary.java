package com.galvix.galvixassessment.dto;

import java.util.StringJoiner;

public class OrderSummary {
	private String orderId;
	private String orderDate;
	private Double totalOrderValue;
	private Double averageUnitPrice;
	private Integer unitCount;
	private String customerState;

	public OrderSummary() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalOrderValue() {
		return totalOrderValue;
	}

	public void setTotalOrderValue(Double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}

	public Double getAverageUnitPrice() {
		return averageUnitPrice;
	}

	public void setAverageUnitPrice(Double averageUnitPrice) {
		this.averageUnitPrice = averageUnitPrice;
	}

	public Integer getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(Integer unitCount) {
		this.unitCount = unitCount;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", OrderSummary.class.getSimpleName() + "[", "]").add("orderId='" + orderId + "'")
				.add("orderDate='" + orderDate + "'").add("totalOrderValue=" + totalOrderValue)
				.add("averageUnitPrice=" + averageUnitPrice).add("unitCount=" + unitCount)
				.add("customerState='" + customerState + "'").toString();
	}
}
