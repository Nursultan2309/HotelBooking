package com.example.Department.models.dto;

import com.example.Department.models.entity.Review;
import com.example.Department.models.entity.User;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ReplyToReviewDto {

    Long id;
    String text;
    User user;
    LocalDate date;
    Review review;
}

