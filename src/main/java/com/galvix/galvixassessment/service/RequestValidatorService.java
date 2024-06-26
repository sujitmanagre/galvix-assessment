package com.galvix.galvixassessment.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.galvix.galvixassessment.exception.CustomException;

@Service
public class RequestValidatorService {

	public void requestValidator(MultipartFile file, String fileType) {

		if (file == null || file.isEmpty()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "file must not be null or empty");
		}

		// since currently supporting only jsonl file as an input
		// this validation can be removed later when we support multiple formats
		if (!isJsonL(file.getOriginalFilename(), "jsonl")) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "file format must be jsonl");
		}

		if (!isJsonL(file.getOriginalFilename(), fileType)) {
			throw new CustomException(HttpStatus.BAD_REQUEST, "file type and file format does not match");
		}

	}

	private boolean isJsonL(String filename, String fileType) {
		return filename.toLowerCase().endsWith("." + fileType);
	}
}
