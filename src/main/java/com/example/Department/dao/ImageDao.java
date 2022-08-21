package com.example.Department.dao;

import com.example.Department.models.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageDao extends JpaRepository<Image, Long> {
}
