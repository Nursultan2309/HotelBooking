package com.example.Department.models.entity;

import com.example.Department.models.enums.RoomType;
import com.example.Department.models.enums.UserType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room_category_id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Enumerated(EnumType.STRING)
    RoomType roomType;



}
