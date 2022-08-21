package com.example.Department.services.impl;

import com.example.Department.dao.CityDao;
import com.example.Department.mappers.CityMapper;
import com.example.Department.models.dto.CityDto;
import com.example.Department.models.entity.City;
import com.example.Department.models.responce.Message;
import com.example.Department.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    private CityMapper cityMapper = CityMapper.INSTANCE;

    @Override
    public CityDto save(CityDto cityDto) {
        City city = cityMapper.toEntity(cityDto);
        city.setActive(true);
        City citySaved = cityDao.save(city);
        return cityMapper.toDto(citySaved);
    }

    @Override
    public CityDto findById(Long id) {
        City city = cityDao.findById(id).orElse(null);
        return cityMapper.toDto(city);
    }

    @Override
    public ResponseEntity<?> update(CityDto cityDto) {
        boolean isExist = cityDao.existsById(cityDto.getId());
        if (!isExist) {
            return null;
        }
        City city = cityMapper.toEntity(cityDto);
        City cityUpdate = cityDao.save(city);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> delete(CityDto cityDto) {
        City city = cityMapper.toEntity(cityDto);
        city.setActive(false);
       ResponseEntity<?> cityDtoDelete = update(cityMapper.toDto(city));
        if (cityDtoDelete == null) {
            return new ResponseEntity<>(Message.of("Ошибка "), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(Message.of("Город успешно удалено"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<City> cityList = cityDao.findAllByName();
        return ResponseEntity.ok(cityMapper.toDtoList(cityList));
    }
//    @Override
//    public List<CityDto> findAllByActive() {
//       List<City> cities = cityDao.findAllByActive();
//       return cityMapper.toDtoList(cities);
//    }
//}
}




