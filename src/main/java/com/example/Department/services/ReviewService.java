package com.example.Department.services;

import com.example.Department.models.dto.ReviewDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    ReviewDto save(ReviewDto reviewDto);
    ReviewDto update(ReviewDto reviewDto);
    ReviewDto findById(Long id);
    ResponseEntity<?> delete(ReviewDto reviewDto);
    List<ReviewDto> findAllByHotelAndActive(Long hotelId);


}
