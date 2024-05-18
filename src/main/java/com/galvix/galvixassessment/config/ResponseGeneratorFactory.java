package com.galvix.galvixassessment.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galvix.galvixassessment.enums.ResponseType;
import com.galvix.galvixassessment.service.ResponseGenerator;

@Component
public class ResponseGeneratorFactory {
	private final Map<ResponseType, ResponseGenerator> responseGeneratorMap;

	@Autowired
	public ResponseGeneratorFactory(Map<ResponseType, ResponseGenerator> responseGeneratorMap) {
		this.responseGeneratorMap = responseGeneratorMap;
	}

	public ResponseGenerator getResponseGenerator(ResponseType responseType) {
		return responseGeneratorMap.get(responseType);
	}
}
