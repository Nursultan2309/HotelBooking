package com.example.Department.dao;

import com.example.Department.models.entity.Hotel;
import com.example.Department.models.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

  List<Review> findAllByIsActiveTrueAndHotel(Hotel hotel);
}
