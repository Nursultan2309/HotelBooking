package com.example.Department.models.dto;

import com.example.Department.models.enums.Status;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
public class BookingHistoryDto {
        private Long id;
        private BookingDto booking;
        private LocalDate changeDate;
        private String comment;
        private RoomDto room;
        private LocalDate checkInDate;   // даты на какой день заблонирован
        private LocalDate checkOutDate;
        private UserDto quest;
        private Status status;
        private double sum;

}
