package com.example.Department.services;

import com.example.Department.models.dto.BookingHistoryDto;
import org.springframework.http.ResponseEntity;

public interface BookingHistoryService {
    ResponseEntity<?> save(BookingHistoryDto bookingHistoryDto);
    BookingHistoryDto update(BookingHistoryDto bookingHistoryDto);
    BookingHistoryDto findById(Long id);
   // ResponseEntity<?> blockBookingHistory(BookingHistoryDto bookingHistoryDto);
}
