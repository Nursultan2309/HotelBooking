package com.example.Department.models.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.awt.*;

@Data
@Entity
@Table(name = "tb_hotel")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String photos;
    private String phone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;
    private boolean isActive;
    private Double currentScore;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    User manager;


}
