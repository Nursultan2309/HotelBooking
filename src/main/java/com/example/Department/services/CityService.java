package com.example.Department.services;

import com.example.Department.models.dto.CityDto;
import org.springframework.http.ResponseEntity;

public interface CityService {
    CityDto save(CityDto cityDto);
    CityDto findById(Long id);
    ResponseEntity<?> update(CityDto cityDto);
    ResponseEntity<?> delete(CityDto cityDto);
    ResponseEntity<?> findAll();
  //  List<CityDto> findAllByActive();
}
