package com.example.Department.dao;

import com.example.Department.models.dto.UserDto;
import com.example.Department.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
