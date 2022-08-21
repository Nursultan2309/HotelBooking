package com.example.Department.mappers;

import com.example.Department.models.dto.PriceDto;
import com.example.Department.models.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper extends BaseMapper<Price, PriceDto> {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
