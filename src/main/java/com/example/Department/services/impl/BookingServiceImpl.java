package com.example.Department.services.impl;

import com.example.Department.dao.BookingDao;
import com.example.Department.dao.UsersDao;
import com.example.Department.mappers.BookingHistoryMapper;
import com.example.Department.mappers.BookingMapper;
import com.example.Department.mappers.RoomMapper;
import com.example.Department.mappers.UsersMapper;
import com.example.Department.models.dto.BookingDto;
import com.example.Department.models.dto.BookingHistoryDto;
import com.example.Department.models.dto.RoomDto;
import com.example.Department.models.entity.Booking;
import com.example.Department.models.enums.Status;
import com.example.Department.models.responce.Message;
import com.example.Department.services.BookingHistoryService;
import com.example.Department.services.BookingService;
import com.example.Department.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    private BookingMapper bookingMapper = BookingMapper.INSTANCE;
    @Autowired
    BookingHistoryService bookingHistoryService;
    @Autowired
    UserService userService;
    @Autowired
    UsersDao usersDao;
    UsersMapper usersMapper = UsersMapper.INSTANCE;
    RoomMapper roomMapper = RoomMapper.INSTANCE;
    BookingHistoryMapper bookingHistoryMapper = BookingHistoryMapper.INSTANCE;

    @Override
    @Transactional
    public ResponseEntity<?> save(BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        booking.setStatus(Status.ACTIVE);
        Booking bookingSaved = bookingDao.save(booking);

        BookingHistoryDto bookingHistory = new BookingHistoryDto();
        bookingHistory.setBooking(bookingMapper.toDto(bookingSaved));
        bookingHistory.setChangeDate(LocalDate.now());
        bookingHistory.setComment("Created");
        bookingHistory.setRoom(roomMapper.toDto(bookingSaved.getRoom()));
        bookingHistory.setCheckInDate(bookingSaved.getCheckInDate());
        bookingHistory.setCheckOutDate(bookingSaved.getCheckOutDate());
        bookingHistory.setQuest(usersMapper.toDto(bookingSaved.getQuest()));
        // bookingHistory.setUser(bookingDto.getQuest());
        bookingHistory.setStatus(bookingSaved.getStatus());
        ResponseEntity<?> savedBookingHistory = bookingHistoryService.save(bookingHistory);
        return new ResponseEntity<>(bookingSaved, HttpStatus.OK);
    }


    @Override
    public BookingDto update(BookingDto bookingDto) {
        boolean isExist = bookingDao.existsById(bookingDto.getId());
        if (!isExist) {
            return null;
        }
        Booking booking = bookingMapper.toEntity(bookingDto);
        Booking bookingUpdate = bookingDao.save(booking);
        return bookingMapper.toDto(bookingUpdate);
    }

    @Override
    public BookingDto findById(Long id) {
        Booking booking = bookingDao.findById(id).orElse(null);
        return bookingMapper.toDto(booking);
    }

    @Override
    public ResponseEntity<?> delete(BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        booking.setStatus(Status.INACTIVE);
        BookingDto bookingDelete = update(bookingMapper.toDto(booking));
        if (bookingDelete == null) {
            return new ResponseEntity<>(Message.of("Пустой"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Message.of("блокирован"), HttpStatus.OK);


    }

    @Override
    public ResponseEntity<?> filter(BookingDto bookingDto) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<?> cancelBooking(BookingDto bookingDto, String comment, Long userId) {
        try {
            BookingDto booking = findById(bookingDto.getId());
            Booking entityBooking = bookingMapper.toEntity(booking);
            entityBooking.setStatus(Status.INACTIVE);
            BookingDto canceledBooking = update(bookingMapper.toDto(entityBooking));

            BookingHistoryDto bookingHistory = new BookingHistoryDto();
            bookingHistory.setBooking(bookingDto);
            bookingHistory.setChangeDate(LocalDate.now());
            bookingHistory.setComment(comment);
            bookingHistory.setRoom(roomMapper.toDto(entityBooking.getRoom()));
            bookingHistory.setCheckInDate(entityBooking.getCheckInDate());
            bookingHistory.setCheckOutDate(entityBooking.getCheckOutDate());
            bookingHistory.setQuest(usersMapper.toDto(entityBooking.getQuest()));
         //   bookingHistory.setUser(userService.findById(userId));
            bookingHistory.setStatus(entityBooking.getStatus());
            ResponseEntity<?> savedBookingHistory = bookingHistoryService.save(bookingHistory);
            return ResponseEntity.ok(canceledBooking);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<BookingDto> findAllByRoomAndActive(RoomDto roomDto) {
        List<Booking> bookings = bookingDao.findAllByRoomAndStatus(roomMapper.toEntity(roomDto), Status.ACTIVE);
        return bookingMapper.toDtoList(bookings);
    }

}
