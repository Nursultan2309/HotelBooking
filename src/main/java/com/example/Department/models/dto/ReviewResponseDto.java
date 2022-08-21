package com.example.Department.models.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ReviewResponseDto {
    private Long id;
    private String text;
    private UserDto users;
    private LocalDate date;
}
