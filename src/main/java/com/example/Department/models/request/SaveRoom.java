package com.example.Department.models.request;

import com.example.Department.models.enums.BedType;
import com.example.Department.models.enums.ETypeOfView;
import com.example.Department.models.enums.RoomType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveRoom {
    @NotBlank(message = "Емкость не должно быть пустой")
    int capacity;
    @NotBlank(message = "Тип кровати не должно быть пустым")
    BedType bedType;
    @NotBlank(message = "Площадь не должно быть пустым")
    float square;
    @NotBlank(message = "Wi-Fi не должно быть пустым")
    boolean wifi;
    @NotBlank(message = "Отел не должно быть пустым")
    Long hotelId;
    @NotBlank(message = "Тип просмотра не должно быть пустым")
    ETypeOfView typeOfView;
    @NotBlank(message = "Тип комнаты не должно быть пустым")
    RoomType type;
    Long roomCategoryId;
}