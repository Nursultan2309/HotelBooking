package com.example.Department.dao;

import com.example.Department.models.entity.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingHistoryDao extends JpaRepository<BookingHistory, Long> {
}
