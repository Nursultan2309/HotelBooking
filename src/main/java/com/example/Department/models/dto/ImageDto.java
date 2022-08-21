package com.example.Department.models.dto;

import lombok.AccessLevel;

import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDto {
    Long id;
    String link;
    HotelDto hotel;
    int orderNum;
}
