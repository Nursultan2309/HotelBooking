package com.example.Department.dao;

import com.example.Department.models.entity.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewResponseDao extends JpaRepository<ReviewResponse, Long> {
}
