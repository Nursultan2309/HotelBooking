package com.example.Department.services.impl;

import com.example.Department.dao.ReplyToReviewDao;
import com.example.Department.mappers.ReplyToReviewMapper;
import com.example.Department.models.dto.ReplyToReviewDto;
import com.example.Department.models.entity.ReplyToReview;
import com.example.Department.models.responce.Message;
import com.example.Department.services.ReplyToReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReplyToReviewServiceImpl implements ReplyToReviewService {
    @Autowired
    ReplyToReviewDao replyToReviewDao;
  private final ReplyToReviewMapper replyToReviewMapper = ReplyToReviewMapper.INSTANCE;


    @Override
    public ResponseEntity<?> save(ReplyToReviewDto replyToReviewDto) {
        ReplyToReview replyToReview = replyToReviewMapper.toEntity(replyToReviewDto);
        replyToReview.setDate(LocalDate.now());
        ReplyToReview saveReplyToReview = replyToReviewDao.save(replyToReview);

        return new ResponseEntity<>(saveReplyToReview, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(ReplyToReviewDto replyToReviewDto) {
        ReplyToReview replyToReview = replyToReviewMapper.toEntity(replyToReviewDto);
        replyToReviewDao.deleteById(replyToReview.getId());

        return new ResponseEntity<>(Message.of("ReplyToReview deleted"), HttpStatus.OK);
    }
}
