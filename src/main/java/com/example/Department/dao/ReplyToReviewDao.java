package com.example.Department.dao;

import com.example.Department.models.entity.ReplyToReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyToReviewDao extends JpaRepository<ReplyToReview, Long> {
}
