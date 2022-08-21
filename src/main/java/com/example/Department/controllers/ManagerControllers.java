package com.example.Department.controllers;

import com.example.Department.models.dto.*;
import com.example.Department.models.request.SaveRoom;
import com.example.Department.models.request.ToSaveCategoryAndPrice;
import com.example.Department.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/owner")
public class ManagerControllers {

    @Autowired
    private BookingService bookingService;
    @Autowired
    RoomService roomService;
    @Autowired
    private PriceService priceService;
    @Autowired
    BookingHistoryService bookingHistoryService;
    @Autowired
    HotelService hotelService;
    @Autowired
    FileServerce fileServerce;
    @Autowired
    RoomCategoryService roomCategoryService;
    @Autowired
    ReplyToReviewService replyToReviewService;


    @PostMapping("/save/booking")
    public ResponseEntity<?> save(@RequestBody BookingDto bookingDto) {
        return bookingService.save(bookingDto);
    }
    @PutMapping("/update/booking")
    public BookingDto update(@RequestBody BookingDto bookingDto) {
        return bookingService.update(bookingDto);
    }
    @DeleteMapping("/deleteBooking")
    public ResponseEntity<?> deleteBooking (@RequestBody BookingDto bookingDto){
        return bookingService.delete(bookingDto);
    }


    @PutMapping("/update/hotel")
    public ResponseEntity<?> update(@RequestBody HotelDto hotelDto) {
        return hotelService.update(hotelDto);
    }
    @DeleteMapping("/deleteHotel")
    public ResponseEntity<?> deleteHotel (@RequestBody HotelDto hotelDto){
        return hotelService.deleteHotel(hotelDto);
    }


    @PostMapping("/save/price")
    public PriceDto save(@RequestBody PriceDto priceDto) {
        return priceService.save(priceDto);
    }
    @PutMapping("/update/price")
    public PriceDto update(@RequestBody PriceDto priceDto) {
        return priceService.update(priceDto);
    }
    @DeleteMapping("/deletePrice")
    public ResponseEntity<?> deletePrice (@RequestBody PriceDto priceDto){
        return priceService.delete(priceDto);
    }


    @PostMapping("/save/room_category")
    public RoomCategoryDto save(@RequestBody RoomCategoryDto roomCategoryDto) {
        return roomCategoryService.save(roomCategoryDto);
    }


    @PostMapping("/saveRoom/Price")
    public ResponseEntity<?> saveRoomWithPrice(@RequestBody ToSaveCategoryAndPrice toSaveCategoryAndPrice) {
        return roomCategoryService.saveCategoryAndPrice(toSaveCategoryAndPrice);
    }
    @PostMapping("/saveRoom")
    public ResponseEntity<?> saveRoom(@RequestBody SaveRoom saveRoom){
        return roomService.saveRoom(saveRoom);
    }
    @PutMapping("/update/room")
    public ResponseEntity<?> update(@RequestBody RoomDto roomDto) {
        return roomService.update(roomDto);
    }
    @DeleteMapping("/deleteRoom")
    public ResponseEntity<?> deleteRoom(@RequestBody RoomDto roomDto){
        return roomService.delete(roomDto);
    }


    @PostMapping("/save/booking_history")
    public ResponseEntity<?> save(@RequestBody BookingHistoryDto bookingHistoryDto) {
        return bookingHistoryService.save(bookingHistoryDto);
    }
    @PutMapping("/update/booking_history")
    public BookingHistoryDto update(@RequestBody BookingHistoryDto bookingHistoryDto) {
        return bookingHistoryService.update(bookingHistoryDto);
    }



    @PostMapping("/uploadImg")
    public ResponseEntity<?> uploadImageToHotel(@RequestParam MultipartFile file, @RequestParam Long hotelId, @RequestParam int orderNum) {
        return fileServerce.uploadImageToHotel(file, hotelId, orderNum);
    }

 





}




