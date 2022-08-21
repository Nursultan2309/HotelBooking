package com.example.Department.services;

import com.example.Department.models.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto);
    UserDto findById(Long id);
    ResponseEntity<?> delete(UserDto userDto);
    ResponseEntity<?> findByEmail(String email);

}
