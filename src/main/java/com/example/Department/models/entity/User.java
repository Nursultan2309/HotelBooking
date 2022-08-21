package com.example.Department.models.entity;

import com.example.Department.models.enums.Status;
import com.example.Department.models.enums.UserType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "tb_users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;    // гость, Менеджер, Супер Админ
    @Enumerated(EnumType.STRING)
    private Status status;
}
