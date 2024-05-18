package com.galvix.galvixassessment.service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.galvix.galvixassessment.dto.OrderResponse;
import com.galvix.galvixassessment.dto.response.Customer;
import com.galvix.galvixassessment.dto.response.Item;
import com.galvix.galvixassessment.dto.response.Order;

public interface ResponseGenerator {

	Object generateResponse(List<Order> orders) throws IOException;

	static List<OrderResponse> generateJsonResponse(List<Order> orders) {
		List<OrderResponse> orderResponses = new ArrayList<>();
		for (Order order : orders) {
			OrderResponse orderResponse = orderToOrderResponse(order);
			orderResponses.add(orderResponse);
		}

		return orderResponses;
	}

	private static OrderResponse orderToOrderResponse(Order order) {
		OrderResponse orderResponse = new OrderResponse();
		if (order == null)
			return orderResponse;

		orderResponse.setOrderId(order.getOrderId());
		orderResponse.setOrderDate(order.getOrderDatetime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		orderResponse.setTotalOrderValue(calculateTotalOrderValue(order.getItems()));
		orderResponse.setAverageUnitPrice(calculateAverageUnitPrice(order.getItems()));
		orderResponse.setUnitCount(calculateUnitCount(order.getItems()));
		orderResponse.setCustomerState(getState(order.getCustomer()));
		return orderResponse;

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
