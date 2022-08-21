package com.example.Department.mappers;

import com.example.Department.models.dto.ReviewResponseDto;
import com.example.Department.models.entity.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewResponseMapper extends BaseMapper<ReviewResponse, ReviewResponseDto> {
    ReviewResponseMapper INSTANCE = Mappers.getMapper(ReviewResponseMapper.class);
}
