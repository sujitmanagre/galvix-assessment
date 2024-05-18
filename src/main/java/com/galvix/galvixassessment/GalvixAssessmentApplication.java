package com.galvix.galvixassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class GalvixAssessmentApplication {

	private final ObjectMapper objectMapper;

	public GalvixAssessmentApplication(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(GalvixAssessmentApplication.class, args);
	}

	@PostConstruct
	public void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
	}

}
