package com.example.Department.services.impl;

import com.example.Department.microservices.FileServiceFeign;
import com.example.Department.microservices.json.FileServiceResponse;
import com.example.Department.models.dto.HotelDto;
import com.example.Department.models.dto.ImageDto;
import com.example.Department.models.responce.Message;
import com.example.Department.services.FileServerce;
import com.example.Department.services.HotelService;
import com.example.Department.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServerceImpl implements FileServerce {

    @Autowired
    FileServiceFeign fileServiceFeign;
    @Autowired HotelService hotelService;
    @Autowired
    ImageService imageService;

    @Override
    public ResponseEntity<?> uploadImageToHotel(MultipartFile file, Long hotelId, int orderNum) {
        HotelDto hotelDto = hotelService.findById(hotelId);
        if(hotelDto != null) {
            ImageDto image = new ImageDto();
            image.setHotel(hotelDto);
            image.setOrderNum(orderNum);
            try {
                FileServiceResponse response = fileServiceFeign.upload(file);
                image.setLink(response.getDownloadUri());
                ImageDto saved = imageService.save(image);
                return ResponseEntity.ok(saved);
            }catch (Exception e){
                return new ResponseEntity<>(Message.of("Не удалось сохранить фото"), HttpStatus.NOT_ACCEPTABLE);
            }


        }
        return new ResponseEntity<>(Message.of("Не удалось найти объект отеля"), HttpStatus.NOT_ACCEPTABLE);
    }
}
