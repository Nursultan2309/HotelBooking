package com.example.Department.dao;

import com.example.Department.models.entity.Booking;
import com.example.Department.models.entity.Room;
import com.example.Department.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {
    List<Booking> findAllByRoomAndStatus(Room room, Status status);
}
