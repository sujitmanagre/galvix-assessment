package com.galvix.galvixassessment.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.galvix.galvixassessment.dto.OrderResponse;
import com.galvix.galvixassessment.dto.response.Order;
import com.galvix.galvixassessment.service.ResponseGenerator;

public class YamlResponseGeneratorImpl implements ResponseGenerator {
	private final YAMLMapper yamlMapper;

	public YamlResponseGeneratorImpl() {
		this.yamlMapper = new YAMLMapper();
	}

	@Override
	public Object generateResponse(List<Order> orders) throws IOException {
		List<OrderResponse> orderResponses = ResponseGenerator.generateJsonResponse(orders);
		return yamlMapper.writeValueAsString(orderResponses);
	}
}
