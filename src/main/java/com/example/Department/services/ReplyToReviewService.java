package com.example.Department.services;

import com.example.Department.models.dto.ReplyToReviewDto;
import org.springframework.http.ResponseEntity;

public interface ReplyToReviewService {
    ResponseEntity<?> save(ReplyToReviewDto replyToReviewDto);
    ResponseEntity<?> delete(ReplyToReviewDto replyToReviewDto);
}
