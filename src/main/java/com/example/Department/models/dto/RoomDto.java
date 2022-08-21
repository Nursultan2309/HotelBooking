package com.example.Department.models.dto;


import com.example.Department.models.enums.BedType;
import com.example.Department.models.enums.ETypeOfView;
import com.example.Department.models.enums.RoomType;
import com.example.Department.models.enums.Status;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Data
public class RoomDto {
     Long id;
     int capacity;     // вместимость человека
     BedType bedType;   // тип кровати
     double square;    // площадь комнаты
     boolean wifi;
     ETypeOfView typeOfView;
     HotelDto hotel;
     RoomType type;    // стантарт, люкс, вип т.д
    boolean isActive;
    RoomCategoryDto roomCategory;
}
