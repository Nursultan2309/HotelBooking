package com.example.Department.models.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data

public class PriceDto {
    private Long id;
    private float price;
    private LocalDate startDate;
    private  LocalDate endDate;
    private RoomCategoryDto roomCategory;
    private boolean isActive;

}
