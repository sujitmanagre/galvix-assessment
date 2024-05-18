package com.galvix.galvixassessment.service;

import java.util.List;

import com.galvix.galvixassessment.dto.OrderResponse;
import com.galvix.galvixassessment.dto.response.Order;

public interface ResponseGenerator {

	List<OrderResponse> generateResponse(List<Order> orders);
}
