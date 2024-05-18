package com.galvix.galvixassessment.service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.galvix.galvixassessment.dto.Customer;
import com.galvix.galvixassessment.dto.Item;
import com.galvix.galvixassessment.dto.Order;
import com.galvix.galvixassessment.dto.OrderSummary;

public interface ResponseGenerator {

	Object generateResponse(List<Order> orders) throws IOException;

	static List<OrderSummary> generateJsonResponse(List<Order> orders) {
		List<OrderSummary> orderResponse = new ArrayList<>();
		for (Order order : orders) {
			OrderSummary orderSummary = orderToOrderResponse(order);
			orderResponse.add(orderSummary);
		}

		return orderResponse;
	}

	private static OrderSummary orderToOrderResponse(Order order) {
		OrderSummary orderSummary = new OrderSummary();
		if (order == null)
			return orderSummary;

		orderSummary.setOrderId(order.getOrderId());
		orderSummary.setOrderDate(order.getOrderDatetime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		orderSummary.setTotalOrderValue(calculateTotalOrderValue(order.getItems()));
		orderSummary.setAverageUnitPrice(calculateAverageUnitPrice(order.getItems()));
		orderSummary.setUnitCount(calculateUnitCount(order.getItems()));
		orderSummary.setCustomerState(getState(order.getCustomer()));
		return orderSummary;

	}

	private static double calculateTotalOrderValue(List<Item> items) {
		double orderValue = 0;
		for (Item item : items) {
			orderValue += item.getQuantity() * item.getUnitPrice();
		}
		return orderValue;
	}

	private static double calculateAverageUnitPrice(List<Item> items) {
		double totalPrice = items.stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
		int totalQuantity = items.stream().mapToInt(Item::getQuantity).sum();
		return totalQuantity > 0 ? totalPrice / totalQuantity : 0.0;
	}

	private static int calculateUnitCount(List<Item> items) {
		return items.stream().mapToInt(Item::getQuantity).sum();
	}

	private static String getState(Customer customer) {
		if (customer == null || customer.getShippingAddress() == null
				|| customer.getShippingAddress().getState() == null)
			return "";
		else
			return customer.getShippingAddress().getState();
	}
}
