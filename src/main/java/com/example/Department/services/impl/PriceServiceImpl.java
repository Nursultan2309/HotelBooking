package com.example.Department.services.impl;

import com.example.Department.dao.PriceDao;
import com.example.Department.mappers.PriceMapper;
import com.example.Department.mappers.RoomCategotyMapper;
import com.example.Department.mappers.RoomMapper;
import com.example.Department.models.dto.PriceDto;
import com.example.Department.models.dto.RoomCategoryDto;
import com.example.Department.models.entity.Price;
import com.example.Department.models.responce.Message;
import com.example.Department.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired private PriceDao priceDao;
    private PriceMapper priceMapper = PriceMapper.INSTANCE;
    private RoomCategotyMapper roomCategotyMapper = RoomCategotyMapper.INSTANCE;
private RoomMapper roomMapper = RoomMapper.INSTANCE;
    @Override
    public PriceDto save(PriceDto priceDto) {
        Price price = priceMapper.toEntity(priceDto);
        price.setActive(true);
        Price priceSaved = priceDao.save(price);
        return priceMapper.toDto(priceSaved);
    }

    @Override
    public PriceDto update(PriceDto priceDto) {
        boolean isExist = priceDao.existsById(priceDto.getId());
        if (!isExist) {
            return null;
        }
        Price price = priceMapper.toEntity(priceDto);
        Price priceUpdate = priceDao.save(price);
        return priceMapper.toDto(priceUpdate);
    }

    @Override
    public PriceDto findById(Long id) {
        Price price = priceDao.findById(id).orElse(null);
        return priceMapper.toDto(price);
    }

    @Override
    public ResponseEntity<?> delete(PriceDto priceDto) {
        Price price = priceMapper.toEntity(priceDto);
        price.setActive(false);
        PriceDto priceDelete = update(priceMapper.toDto(price));
        if(priceDelete == null){
            return new ResponseEntity<>(Message.of("Цена не найден"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Message.of("Цена успешно удалено"),HttpStatus.OK);
    }

    @Override
    public PriceDto findPriceByRoom(RoomCategoryDto roomCategoryDto, LocalDate date) {

        Price price = priceDao.findByRoomCategory(roomCategotyMapper.toEntity(roomCategoryDto),date);

        return priceMapper.toDto(price);
    }
}
