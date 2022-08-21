package com.example.Department.services.impl;


import com.example.Department.dao.RoomCategoryDao;
import com.example.Department.mappers.RoomCategotyMapper;
import com.example.Department.models.dto.PriceDto;
import com.example.Department.models.dto.RoomCategoryDto;
import com.example.Department.models.entity.RoomCategory;
import com.example.Department.models.request.ToSaveCategoryAndPrice;
import com.example.Department.services.PriceService;
import com.example.Department.services.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {
    @Autowired RoomCategoryService roomCategoryService;
    @Autowired RoomCategoryDao roomCategoryDao;
    @Autowired
    PriceService priceService;
    RoomCategotyMapper roomCategotyMapper = RoomCategotyMapper.INSTANCE;

    @Override
    public RoomCategoryDto save(RoomCategoryDto roomCategoryDto) {
        RoomCategory roomCategory = roomCategotyMapper.toEntity(roomCategoryDto);
        RoomCategory savedRoomCategory = roomCategoryDao.save(roomCategory);
        return roomCategotyMapper.toDto(savedRoomCategory);
    }

    @Override
    public RoomCategoryDto update(RoomCategoryDto roomCategoryDto) {
        boolean isExist = roomCategoryDao.existsById(roomCategoryDto.getId());
        if(!isExist){
            return null;
        }
        RoomCategory roomCategory = roomCategotyMapper.toEntity(roomCategoryDto);
        RoomCategory updateRoomCategory = roomCategoryDao.save(roomCategory);
        return roomCategotyMapper.toDto(updateRoomCategory);
    }

    @Override
    public RoomCategoryDto findById(Long roomCategoryId) {
        RoomCategory roomCategory = roomCategoryDao.findById(roomCategoryId).orElse(null);
        return roomCategotyMapper.toDto(roomCategory);
    }
    @Override
    @Transactional
    public ResponseEntity<?> saveCategoryAndPrice(ToSaveCategoryAndPrice saveCategoryAndPrice) {
        RoomCategory roomCategory = new RoomCategory();
        roomCategory.setRoomType(saveCategoryAndPrice.getTypeOfRoom());
        RoomCategoryDto savedRoomCategory = save(roomCategotyMapper.toDto(roomCategory));

        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(saveCategoryAndPrice.getPrice());
        priceDto.setStartDate(saveCategoryAndPrice.getStartDate());
        priceDto.setEndDate(saveCategoryAndPrice.getEndDate());
        priceDto.setRoomCategory(savedRoomCategory);
        PriceDto savedPrice = priceService.save(priceDto);


     //  logger.info("SaveCategoryAndPrice successfully saved: -> " + roomCategory + " price: -> " + priceDto);
        return new ResponseEntity<>(savedPrice, HttpStatus.OK);
    }
}
