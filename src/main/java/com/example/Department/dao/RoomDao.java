package com.example.Department.dao;

import com.example.Department.models.entity.Hotel;
import com.example.Department.models.entity.Room;
import com.example.Department.models.entity.RoomCategory;
import com.example.Department.models.enums.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDao extends JpaRepository<Room, Long> {
   @Query("select r from Room r where r.hotel = ?1 and r.bedType = ?2 and r.capacity >= ?3")
    List<Room> findAllByActiveTrueAndHotelAndBedTypeAndCapacity(Hotel hotel, BedType bedType, int capacity);

}
