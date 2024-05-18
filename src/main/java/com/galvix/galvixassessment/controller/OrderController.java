package com.galvix.galvixassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.galvix.galvixassessment.enums.ResponseType;
import com.galvix.galvixassessment.service.OrderService;
import com.galvix.galvixassessment.service.RequestValidatorService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private RequestValidatorService requestValidatorService;
	@Autowired
	private OrderService orderService;

	@PostMapping("/summary")
	public ResponseEntity<?> orderDetails(@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType, @RequestParam("responseType") ResponseType responseType,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		try {
			boolean validate = requestValidatorService.validateFile(file, fileType);
			if (!validate)
				return new ResponseEntity<>("Invalid file type or empty file", HttpStatus.BAD_REQUEST);
			Object response = orderService.orderDetails(file, responseType, page, size);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
