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
@Table(name = "tb_review_response")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

}
