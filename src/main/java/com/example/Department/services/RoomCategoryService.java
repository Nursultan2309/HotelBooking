package com.example.Department.services;

import com.example.Department.models.dto.RoomCategoryDto;
import com.example.Department.models.request.ToSaveCategoryAndPrice;
import org.springframework.http.ResponseEntity;

public interface RoomCategoryService {
    RoomCategoryDto save(RoomCategoryDto roomCategoryDto);
    RoomCategoryDto update (RoomCategoryDto roomCategoryDto);
    RoomCategoryDto findById (Long roomCategoryId);
    ResponseEntity<?> saveCategoryAndPrice(ToSaveCategoryAndPrice saveCategoryAndPrice);
}
