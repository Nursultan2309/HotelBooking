package com.example.Department.models.dto;

import com.example.Department.models.enums.Status;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class BookingDto {
    private Long id;
    private HotelDto hotel;
    private RoomDto room;
    private LocalDate checkInDate;   // даты на какой день заблонирован
    private LocalDate checkOutDate;
    private UserDto quest;
    private String comment;
    private Status status;
    private float priceOfBook;

}
