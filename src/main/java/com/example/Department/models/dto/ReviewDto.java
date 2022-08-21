package com.example.Department.models.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReviewDto {
    private Long id;
    private UserDto quest;
    private HotelDto hotel;
    private Double score;    // оценка
    private String text;
    private ReviewResponseDto response;
    private boolean isActive;
    private LocalDate date;
}
