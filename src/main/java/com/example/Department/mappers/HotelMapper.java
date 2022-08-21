package com.example.Department.mappers;

import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper extends BaseMapper<Hotel, HotelDto> {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
}
