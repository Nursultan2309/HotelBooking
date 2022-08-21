package com.example.Department.controllers;

import com.example.Department.models.dto.*;
import com.example.Department.models.enums.BedType;
import com.example.Department.models.responce.Message;
import com.example.Department.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/quest")
public class UserControllers {

    @Autowired UserService userService;
    @Autowired ReviewService reviewService;
    @Autowired HotelService hotelService;
    @Autowired BookingService bookingService;


    @GetMapping("/mainPage")
    public List<HotelDto> getMainPAge(@RequestParam Long cityId){
        return hotelService.findAllHotelsByCity(cityId);
    }


    @PostMapping("/save/review")
    public ReviewDto save(@RequestBody ReviewDto reviewDto){
        return  reviewService.save(reviewDto);
    }
    @PutMapping("/updateReview")
    public ReviewDto updateReview (@RequestBody ReviewDto reviewDto){
        return reviewService.update(reviewDto);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filter(@RequestParam Long cityId,
                                    @RequestParam
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkInDate,
                                    @RequestParam
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate checkOutDate,
                                    @RequestParam int questsAmount,
                                    @RequestParam BedType bedType){
        return hotelService.filter(cityId, checkInDate, checkOutDate, questsAmount, bedType);
    }

    @PostMapping("/save/booking")
    public ResponseEntity<?> save(@RequestBody BookingDto bookingDto) {
        return bookingService.save(bookingDto);
    }
    @PutMapping("/update/booking")
    public BookingDto update(@RequestBody BookingDto bookingDto) {
        return bookingService.update(bookingDto);
    }
    @DeleteMapping("/deleteBooking")
    public ResponseEntity<?> deleteBooking(@RequestBody BookingDto bookingDto){
        return bookingService.delete(bookingDto);
    }



    @GetMapping("/get/reviewsByHotel")
    public ResponseEntity<?> findAllByHotel(@RequestParam Long hotelId){
    List<ReviewDto> reviewDtos = reviewService.findAllByHotelAndActive(hotelId);
    if(reviewDtos.isEmpty()){
        return new ResponseEntity<>(Message.of("Отзывы по отелю отсутствует"), HttpStatus.NO_CONTENT);
    }else {
        return new ResponseEntity<>(reviewDtos,HttpStatus.OK);
    }
    }
    @DeleteMapping("/deleteReview")
    public ResponseEntity<?> deleteReview(@RequestBody ReviewDto reviewDto){
        return reviewService.delete(reviewDto);
    }

}



