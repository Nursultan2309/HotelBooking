package com.example.Department.models.dto;

import lombok.Data;


@Data
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String photos;
    private String phone;
    private String email;
    private CityDto city;
    private Double currentScore;
    private boolean isActive;
    private UserDto manager;

}
