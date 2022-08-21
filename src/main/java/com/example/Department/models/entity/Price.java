package com.example.Department.models.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Data
@Entity
@Table(name = "tb_price")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {
    @Id
    @GeneratedValue
    private Long id;
    private float price;
    private LocalDate startDate;
    private  LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "room_category_id")

    private RoomCategory roomCategory;
    private boolean isActive;


}
