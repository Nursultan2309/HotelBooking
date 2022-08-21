package com.example.Department.models.entity;

import com.example.Department.models.enums.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table( name = "tb_booking_history")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate changeDate;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate checkInDate;   // даты на какой день заблонирован
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate checkOutDate;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User quest;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double sum;
//    @Column
//    User user;

}
