package com.example.Department.models.responce;

import com.example.Department.models.enums.BedType;
import com.example.Department.models.enums.ETypeOfView;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class RoomFilterResponce {
    Long id;
    int capacity;     // вместимость человека
    BedType bedType;   // тип кровати
    Double square;    // площадь комнаты
    boolean wifi;
    ETypeOfView typeOfView;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    float totalSum;
}
