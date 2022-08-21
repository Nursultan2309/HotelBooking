package com.example.Department.models.request;

import com.example.Department.models.enums.RoomType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "save_category_price")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToSaveCategoryAndPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    RoomType typeOfRoom;
    @NotBlank(message = "Price id must not be empty")
    float price;
    @NotBlank(message = "Start date id must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;
    @NotBlank(message = "End date id must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;
}
