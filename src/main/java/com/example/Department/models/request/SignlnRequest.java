package com.example.Department.models.request;

import com.example.Department.models.enums.Status;
import com.example.Department.models.enums.UserType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class SignlnRequest {
    @NotEmpty(message = "Имя не должно отсуствовать")
    String name;
    @Email(message = "Неверный формат email")
    @NotEmpty(message = "Email не должно отсуствовать")
    String email;
    UserType userType;
    Status status;
}
