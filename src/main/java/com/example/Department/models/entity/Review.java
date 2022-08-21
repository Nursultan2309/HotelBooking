package com.example.Department.models.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_review")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User quest;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private Double score;    // оценка
    private String text;
    @OneToOne
    @JoinColumn(name = "review_response_id")
    private ReviewResponse response;
    private boolean isActive;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

}
