package com.example.Department.services;

import com.example.Department.models.dto.BookingDto;
import com.example.Department.models.dto.RoomDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    ResponseEntity<?> save(BookingDto bookingDto);
    BookingDto update(BookingDto bookingDto);
    BookingDto findById(Long id);
    ResponseEntity<?> delete(BookingDto bookingDto);
    ResponseEntity<?> filter(BookingDto bookingDto);
    ResponseEntity<?> cancelBooking(BookingDto bookingDto, String comment, Long userId);
    List<BookingDto> findAllByRoomAndActive(RoomDto roomDto);




}
