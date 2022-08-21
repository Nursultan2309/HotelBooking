package com.example.Department.dao;

import com.example.Department.models.entity.Price;
import com.example.Department.models.entity.Room;
import com.example.Department.models.entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PriceDao extends JpaRepository<Price, Long> {
    @Query("select p from Price p where p.roomCategory = ?1 and p.startDate <= ?2 and p.endDate >= ?2")
    Price findByRoomCategory(RoomCategory roomCategory, LocalDate date);
}
