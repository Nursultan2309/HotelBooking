package com.example.Department.models.entity;

import com.example.Department.models.enums.BedType;
import com.example.Department.models.enums.ETypeOfView;
import com.example.Department.models.enums.RoomType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_room")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int capacity;     // вместимость человека
    @Enumerated(EnumType.STRING)
    private BedType bedType;   // тип кровати
    private double square;    // площадь комнаты
    private boolean wifi;
    @Enumerated(EnumType.STRING)
    ETypeOfView typeOfView;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private RoomType type;    // стантарт, люкс, вип т.д
    @Column
    boolean isActive;
    @ManyToOne
    @JoinColumn(name = "room_category_id")
    RoomCategory roomCategory;

}
