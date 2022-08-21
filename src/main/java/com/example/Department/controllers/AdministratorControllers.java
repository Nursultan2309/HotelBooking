package com.example.Department.controllers;

import com.example.Department.models.dto.*;
import com.example.Department.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin")
public class AdministratorControllers {


    @Autowired private PriceService priceService;
    @Autowired private CityService cityService;
    @Autowired private HotelService hotelService;
    @Autowired UserService userService;



    @PostMapping("/save/city")
    public CityDto save(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }
    @PutMapping("/updateCity")
    public ResponseEntity<?>updateCity(@RequestBody CityDto cityDto){
        return cityService.update(cityDto);
    }
    @GetMapping("/get/List")
    ResponseEntity<?> findAll(){
        return cityService.findAll();
    }
    @DeleteMapping("/deleteCity")
    public ResponseEntity<?> deleteCity(@RequestBody CityDto cityDto){
        return cityService.delete(cityDto);
    }



    @PostMapping("/save/hotel")
    public ResponseEntity<?> save(@RequestBody HotelDto hotelDto){
        return hotelService.save(hotelDto);
    }
    @PutMapping("/updateHotel")
    public ResponseEntity<?> updateHotel(@RequestBody HotelDto hotelDto){
        return hotelService.save(hotelDto);
    }
    @DeleteMapping("/deleteHotel")
    public ResponseEntity<?> deleteHotel(@RequestBody HotelDto hotelDto){
        return hotelService.deleteHotel(hotelDto);
    }


    @PostMapping("/save/user")
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
    return userService.update(userDto);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody UserDto userDto){
        return userService.delete(userDto);
    }
    }


