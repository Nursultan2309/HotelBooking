package com.example.Department.services.impl;

import com.example.Department.dao.ReviewResponseDao;
import com.example.Department.mappers.ReviewResponseMapper;
import com.example.Department.models.dto.ReviewResponseDto;
import com.example.Department.models.entity.ReviewResponse;
import com.example.Department.services.ReviewResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewResponseServiceImpl implements ReviewResponseService {
    @Autowired private ReviewResponseDao reviewResponseDao;
    private ReviewResponseMapper reviewResponseMapper = ReviewResponseMapper.INSTANCE;

    @Override
    public ReviewResponseDto save(ReviewResponseDto reviewResponseDto) {
        ReviewResponse response = reviewResponseMapper.toEntity(reviewResponseDto);
        ReviewResponse responseSaved = reviewResponseDao.save(response);
        return reviewResponseMapper.toDto(responseSaved);
    }

    @Override
    public ReviewResponseDto update(ReviewResponseDto reviewResponseDto) {
        boolean isExist = reviewResponseDao.existsById(reviewResponseDto.getId());
        if (!isExist) {
            return null;
        }
        ReviewResponse response = reviewResponseMapper.toEntity(reviewResponseDto);
        ReviewResponse responseUpdate = reviewResponseDao.save(response);
        return reviewResponseMapper.toDto(responseUpdate);
    }
}
