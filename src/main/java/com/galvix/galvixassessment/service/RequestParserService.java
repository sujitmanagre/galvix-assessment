package com.galvix.galvixassessment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.galvix.galvixassessment.dto.response.Order;

@Service
public class RequestParserService {
	private final ObjectMapper objectMapper;

	public RequestParserService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
		this.objectMapper.registerModule(new JavaTimeModule());
	}

	public List<Order> readJsonlFile(MultipartFile file) throws IOException {
		List<Order> orders = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Order order = objectMapper.readValue(line, Order.class);
				orders.add(order);
			}
		}
		return orders;
	}

}
