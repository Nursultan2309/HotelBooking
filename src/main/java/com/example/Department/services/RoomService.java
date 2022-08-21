package com.example.Department.services;

import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.dto.RoomDto;
import com.example.Department.models.entity.Hotel;
import com.example.Department.models.enums.BedType;
import com.example.Department.models.request.SaveRoom;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {
     RoomDto save(RoomDto roomDto);
     ResponseEntity<?> saveRoom(SaveRoom saveRoom);
     ResponseEntity<?> update(RoomDto roomDto);
     RoomDto findById(Long id);
     ResponseEntity<?> delete(RoomDto roomDto);
 List<RoomDto> findAllRoomsByHotel(Hotel hotel, BedType bedType, int capacity);


}
