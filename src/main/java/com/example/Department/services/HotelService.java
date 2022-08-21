package com.example.Department.services;

import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.enums.BedType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HotelService {
    ResponseEntity<?> save(HotelDto hotelDto);
    ResponseEntity<?> update(HotelDto hotelDto);
    HotelDto findById(Long id);
    ResponseEntity<?> deleteHotel(HotelDto hotelDto);
    ResponseEntity<?> findAllByCityAndByRating(Long cityId);
    List<HotelDto> findAllHotelsByCity(Long cityId);
    ResponseEntity<?>filter(Long cityId, LocalDate checkInDate, LocalDate checkOutDate, int questAmount, BedType bedType);
    List<HotelDto> findAll();
    void countCurrentScore();
}
