package com.galvix.galvixassessment.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.galvix.galvixassessment.config.ResponseGeneratorFactory;
import com.galvix.galvixassessment.config.ServiceConfig;
import com.galvix.galvixassessment.dto.response.Order;
import com.galvix.galvixassessment.enums.ResponseType;

@Service
public class OrderService {

	@Autowired
	private RequestParserService requestParserService;
	@Autowired
	private ServiceConfig serviceConfig;
	@Autowired
	private ResponseGeneratorFactory responseGeneratorFactory;

	public Object orderDetails(MultipartFile file, ResponseType responseType, int page, int size) throws IOException {
		try {
			List<Order> orders = requestParserService.readJsonlFile(file, page, size);

			ResponseGenerator responseGenerator = responseGeneratorFactory.getResponseGenerator(responseType);

			return responseGenerator.generateResponse(orders);
		} catch (Exception e) {
			throw e;
		}
	}

}
