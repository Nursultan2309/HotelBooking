package com.example.Department.mappers;

import com.example.Department.models.dto.CityDto;
import com.example.Department.models.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper extends BaseMapper<City, CityDto> {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
}
