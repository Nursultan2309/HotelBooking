package com.example.Department.mappers;

import com.example.Department.models.dto.ReviewDto;
import com.example.Department.models.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper extends BaseMapper<Review, ReviewDto> {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
}
