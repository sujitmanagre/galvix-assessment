package com.galvix.galvixassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.galvix.galvixassessment.enums.ResponseType;
import com.galvix.galvixassessment.service.OrderService;
import com.galvix.galvixassessment.service.RequestValidatorService;

@RestController
public class OrderController {

	@Autowired
	private RequestValidatorService requestValidatorService;
	@Autowired
	private OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<?> orderDetails(@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType, @RequestParam("responseType") ResponseType responseType) {
		try {
			boolean validate = requestValidatorService.validateFile(file, fileType);
			if (!validate)
				return new ResponseEntity<>("Invalid file type", HttpStatus.BAD_REQUEST);
			Object o = orderService.orderDetails(file, responseType);
			return new ResponseEntity<>(o, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
