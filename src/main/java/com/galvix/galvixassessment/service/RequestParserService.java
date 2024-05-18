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
import com.galvix.galvixassessment.dto.Order;

@Service
public class RequestParserService {
	private final ObjectMapper objectMapper;

	public RequestParserService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
		this.objectMapper.registerModule(new JavaTimeModule());
	}

	public List<Order> readJsonlFile(MultipartFile file, int page, int size) throws IOException {
		List<Order> orders = new ArrayList<>();
		int startLine = page * size;
		int limit = size;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			int currentLine = 0;
			int linesRead = 0;
			while ((line = reader.readLine()) != null) {
				if (currentLine++ < startLine) {
					continue;
				}

				Order order = objectMapper.readValue(line, Order.class);
				orders.add(order);
				linesRead++;

				if (linesRead >= limit) {
					break;
				}
			}
		}
		return orders;
	}

}
