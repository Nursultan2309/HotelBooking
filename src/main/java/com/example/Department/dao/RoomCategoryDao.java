package com.example.Department.dao;

import com.example.Department.models.entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryDao extends JpaRepository<RoomCategory, Long> {

}
