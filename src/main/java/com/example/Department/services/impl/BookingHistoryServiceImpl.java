package com.example.Department.services.impl;

import com.example.Department.dao.BookingHistoryDao;
import com.example.Department.mappers.BookingHistoryMapper;
import com.example.Department.models.dto.BookingHistoryDto;
import com.example.Department.models.entity.BookingHistory;
import com.example.Department.models.enums.Status;
import com.example.Department.services.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {
    @Autowired private BookingHistoryDao bookingHistoryDao;
    private BookingHistoryMapper bookingHistoryMapper = BookingHistoryMapper.INSTANCE;

    @Override
    public ResponseEntity<?> save(BookingHistoryDto bookingHistoryDto) {
        BookingHistory bookingHistory = bookingHistoryMapper.toEntity(bookingHistoryDto);
        bookingHistory.setStatus(Status.ACTIVE);
        BookingHistory bookingHistorySaved = bookingHistoryDao.save(bookingHistory);
        return  ResponseEntity.ok( bookingHistoryMapper.toDto(bookingHistorySaved));
    }

    @Override
    public BookingHistoryDto update(BookingHistoryDto bookingHistoryDto) {
        boolean isExist = bookingHistoryDao.existsById(bookingHistoryDto.getId());
        if (!isExist) {
            return null;
        }
        BookingHistory bookingHistory = bookingHistoryMapper.toEntity(bookingHistoryDto);
        BookingHistory bookingHistoryUpdate = bookingHistoryDao.save(bookingHistory);
        return bookingHistoryMapper.toDto(bookingHistoryUpdate);
    }

    @Override
    public BookingHistoryDto findById(Long id) {
        BookingHistory bookingHistory = bookingHistoryDao.findById(id).orElse(null);
        return bookingHistoryMapper.toDto(bookingHistory);
    }

//    @Override
//    public ResponseEntity<?> blockBookingHistory(BookingHistoryDto bookingHistoryDto) {
//        BookingHistory bookingHistory = bookingHistoryMapper.toEntity(bookingHistoryDto);
//        bookingHistory.setStatus(Status.BLOCK);
//        BookingHistoryDto bookingHistoryDtoBlock = update(bookingHistoryMapper.toDto(bookingHistory));
//        if(bookingHistoryDtoBlock == null){
//            return new ResponseEntity<>(Message.of("История броня не найден"), HttpStatus.NOT_ACCEPTABLE);
//        }
//        return new ResponseEntity<>(Message.of("Бронь истории заблокирован"), HttpStatus.OK);
//    }
}
