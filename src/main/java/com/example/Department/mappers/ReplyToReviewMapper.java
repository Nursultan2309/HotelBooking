package com.example.Department.mappers;

import com.example.Department.models.dto.ReplyToReviewDto;
import com.example.Department.models.entity.ReplyToReview;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReplyToReviewMapper extends BaseMapper<ReplyToReview, ReplyToReviewDto>{
    ReplyToReviewMapper INSTANCE = Mappers.getMapper(ReplyToReviewMapper.class);
}
