package com.example.Department.models.dto;

import com.example.Department.models.enums.RoomType;
import com.example.Department.models.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomCategoryDto {

    @JsonIgnore
    Long id;
    RoomType roomType;

}
