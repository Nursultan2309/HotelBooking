package com.example.Department.models.dto;

import com.example.Department.models.enums.Status;
import com.example.Department.models.enums.UserType;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private UserType userType;    // гость, Менеджер, Супер Админ
    private Status status;
}
