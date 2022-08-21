package com.example.Department.services;

import com.example.Department.models.dto.PriceDto;
import com.example.Department.models.dto.RoomCategoryDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface PriceService {
    PriceDto save(PriceDto priceDto);
    PriceDto update(PriceDto priceDto);
    PriceDto findById(Long id);
    ResponseEntity<?> delete(PriceDto priceDto);
    PriceDto findPriceByRoom(RoomCategoryDto roomCategoryDto, LocalDate date);

}
