package com.example.Department.services.impl;

import com.example.Department.dao.RoomDao;
import com.example.Department.mappers.RoomMapper;
import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.dto.RoomCategoryDto;
import com.example.Department.models.dto.RoomDto;
import com.example.Department.models.entity.Hotel;
import com.example.Department.models.entity.Room;
import com.example.Department.models.enums.BedType;
import com.example.Department.models.enums.Status;

import com.example.Department.models.exceptions.RoomException;
import com.example.Department.models.request.SaveRoom;
import com.example.Department.models.responce.Message;
import com.example.Department.services.HotelService;
import com.example.Department.services.RoomCategoryService;
import com.example.Department.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
    @Autowired private RoomDao roomDao;
    private RoomMapper roomMapper = RoomMapper.INSTANCE;
    @Autowired HotelService hotelService;
    @Autowired RoomCategoryService roomCategoryService;

    @Override
    public RoomDto save(RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        room.setActive(true);
        Room roomSaved = roomDao.save(room);
        return roomMapper.toDto(roomSaved);
    }
    @Override
    public ResponseEntity<?> saveRoom(SaveRoom saveRoom) throws RoomException {
        try {
            HotelDto hotelDto = hotelService.findById(saveRoom.getHotelId());
            RoomCategoryDto roomCategoryDto = roomCategoryService.findById(saveRoom.getRoomCategoryId());

            RoomDto room = new RoomDto();
            room.setCapacity(saveRoom.getCapacity());
            room.setBedType(saveRoom.getBedType());
            room.setSquare(saveRoom.getSquare());
            room.setWifi(saveRoom.isWifi());
            room.setHotel(hotelDto);
            room.setActive(true);
            room.setTypeOfView(saveRoom.getTypeOfView());
            room.setRoomCategory(roomCategoryDto);
            room.setType(saveRoom.getType());
            RoomDto savedRoom = save(room);
            return new ResponseEntity<>(savedRoom, HttpStatus.OK);
        }catch (RoomException r){
            logger.error("Failed while saving room(method: saveRoom)");
            RoomException roomException = new RoomException("Failed while saving room(method: saveRoom");
            return new ResponseEntity<>(roomException.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<?> update(RoomDto roomDto) {
        boolean isExist = roomDao.existsById(roomDto.getId());
        if (!isExist) {
            return new ResponseEntity<>(Message.of("Room not fount"),HttpStatus.NOT_ACCEPTABLE);
        }
        Room room = roomMapper.toEntity(roomDto);
        Room roomUpdate = roomDao.save(room);
        return new ResponseEntity<>(roomUpdate, HttpStatus.OK);
    }

    @Override
    public RoomDto findById(Long id) {
        Room room = roomDao.findById(id).orElse(null);
        return roomMapper.toDto(room);
    }

    @Override
    public ResponseEntity<?> delete(RoomDto roomDto) {
        Room room = roomMapper.toEntity(roomDto);
        room.setActive(false);
        ResponseEntity<?> deletedRoom = update(roomMapper.toDto(room));
        if(deletedRoom.getStatusCode().equals(HttpStatus.OK)){
            return new ResponseEntity<>(deletedRoom, HttpStatus.OK);
        }
        return new ResponseEntity<>(Message.of("Room nor ="),HttpStatus.NOT_FOUND);
    }

    @Override
    public List<RoomDto> findAllRoomsByHotel(Hotel hotel, BedType bedType, int capacity) {
        List<Room> rooms = roomDao.findAllByActiveTrueAndHotelAndBedTypeAndCapacity(hotel, bedType ,capacity);

        return roomMapper.toDtoList(rooms);
    }


}
