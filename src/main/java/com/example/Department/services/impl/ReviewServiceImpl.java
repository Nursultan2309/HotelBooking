package com.example.Department.services.impl;

import com.example.Department.dao.ReviewDao;
import com.example.Department.mappers.HotelMapper;
import com.example.Department.mappers.ReviewMapper;
import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.dto.ReviewDto;
import com.example.Department.models.entity.Review;
import com.example.Department.models.responce.Message;
import com.example.Department.services.HotelService;
import com.example.Department.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired private ReviewDao reviewDao;
    @Autowired
    HotelService hotelService;
    private ReviewMapper reviewMapper = ReviewMapper.INSTANCE;
    private HotelMapper hotelMapper;

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review review = reviewMapper.toEntity(reviewDto);
        review.setActive(true);
        Review reviewSaved = reviewDao.save(review);
        return reviewMapper.toDto(reviewSaved);
    }

    @Override
    public ReviewDto update(ReviewDto reviewDto) {
        boolean isExist = reviewDao.existsById(reviewDto.getId());
        if (!isExist) {
            return null;
        }
        Review review = reviewMapper.toEntity(reviewDto);
        Review reviewUpdate = reviewDao.save(review);
        return reviewMapper.toDto(reviewUpdate);
    }

    @Override
    public ReviewDto findById(Long id) {
        Review review = reviewDao.findById(id).orElse(null);
        return reviewMapper.toDto(review);
    }

    @Override
    public ResponseEntity<?> delete(ReviewDto reviewDto) {
        Review review = reviewMapper.toEntity(reviewDto);
        review.setActive(false);
        ReviewDto reviewDtoDelete = update(reviewMapper.toDto(review));
        if(reviewDtoDelete == null){
            return  new ResponseEntity<>(Message.of("Отзыв не найден"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Message.of("Отзыв успешно удалено"),HttpStatus.OK);
    }

    @Override
    public List<ReviewDto> findAllByHotelAndActive(Long hotelId) {
       HotelDto hotel = hotelService.findById(hotelId);
        return reviewMapper.toDtoList(reviewDao.findAllByIsActiveTrueAndHotel(hotelMapper.toEntity(hotel)));

    }
}
