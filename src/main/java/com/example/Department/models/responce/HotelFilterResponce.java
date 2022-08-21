package com.example.Department.models.responce;

import lombok.Data;

import java.util.List;

@Data
public class HotelFilterResponce {

    Long id;
    String description;
    String address;
    String photos;
    String phone;
    Double currentScore;
    String email;
    List<RoomFilterResponce> availableRooms;
}
