package com.example.Department.services;

import com.example.Department.models.dto.ReviewResponseDto;

public interface ReviewResponseService {
    ReviewResponseDto save(ReviewResponseDto reviewResponseDto);
    ReviewResponseDto update(ReviewResponseDto reviewResponseDto);
}
