package com.example.Department.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileServerce {

    ResponseEntity<?> uploadImageToHotel(MultipartFile file, Long hotelId, int orderNum);
}
