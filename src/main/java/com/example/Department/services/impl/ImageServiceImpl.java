package com.example.Department.services.impl;

import com.example.Department.dao.ImageDao;
import com.example.Department.mappers.ImageMapper;
import com.example.Department.models.dto.ImageDto;
import com.example.Department.models.entity.Image;
import com.example.Department.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;
    ImageMapper imageMapper = ImageMapper.INSTANCE;

    @Override
    public ImageDto save(ImageDto imageDto) {
        Image image = imageMapper.toEntity(imageDto);
        Image savedImage = imageDao.save(image);
        return  imageMapper.toDto(savedImage);

    }
}
