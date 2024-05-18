package com.galvix.galvixassessment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.galvix.galvixassessment.dto.response.Order;
import com.galvix.galvixassessment.service.ResponseGenerator;

@Service
public class JsonResponseGeneratorImpl implements ResponseGenerator {
	@Override
	public Object generateResponse(List<Order> orders) {
		return ResponseGenerator.generateJsonResponse(orders);
	}

}
