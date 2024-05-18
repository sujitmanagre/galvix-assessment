package com.galvix.galvixassessment.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.galvix.galvixassessment.enums.ResponseType;
import com.galvix.galvixassessment.service.ResponseGenerator;
import com.galvix.galvixassessment.service.impl.CsvResponseGeneratorImpl;
import com.galvix.galvixassessment.service.impl.JsonResponseGeneratorImpl;
import com.galvix.galvixassessment.service.impl.XmlResponseGeneratorImpl;
import com.galvix.galvixassessment.service.impl.YamlResponseGeneratorImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public Map<ResponseType, ResponseGenerator> responseGeneratorMap() {
		Map<ResponseType, ResponseGenerator> responseGeneratorMap = new HashMap<>();
		responseGeneratorMap.put(ResponseType.JSON, new JsonResponseGeneratorImpl());
		responseGeneratorMap.put(ResponseType.CSV, new CsvResponseGeneratorImpl());
		responseGeneratorMap.put(ResponseType.XML, new XmlResponseGeneratorImpl());
		responseGeneratorMap.put(ResponseType.YAML, new YamlResponseGeneratorImpl());
		return responseGeneratorMap;
	}

}
