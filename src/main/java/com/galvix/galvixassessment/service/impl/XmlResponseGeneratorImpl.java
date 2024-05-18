package com.galvix.galvixassessment.service.impl;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.galvix.galvixassessment.dto.OrderResponse;
import com.galvix.galvixassessment.dto.response.Order;
import com.galvix.galvixassessment.service.ResponseGenerator;

public class XmlResponseGeneratorImpl implements ResponseGenerator {
	private final XmlMapper xmlMapper;

	public XmlResponseGeneratorImpl() {
		this.xmlMapper = new XmlMapper();
	}

	@Override
	public Object generateResponse(List<Order> orders) throws IOException {
		List<OrderResponse> orderResponses = ResponseGenerator.generateJsonResponse(orders);
		return xmlMapper.writeValueAsString(orderResponses);
	}
}
