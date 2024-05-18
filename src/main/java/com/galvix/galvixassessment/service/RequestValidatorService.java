package com.galvix.galvixassessment.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RequestValidatorService {

  public boolean validateFile(MultipartFile file, String fileType) {
    if (file.isEmpty()) {
      return false;
    }

    if (!isJsonL(file.getOriginalFilename(), fileType)) {
      return false;
    }

    return true;
  }

  private boolean isJsonL(String filename, String fileType) {
    return filename.toLowerCase().endsWith("."+fileType);
  }
}
