package com.example.Department.services.impl;

import com.example.Department.dao.UsersDao;
import com.example.Department.mappers.UsersMapper;
import com.example.Department.models.dto.UserDto;
import com.example.Department.models.entity.User;
import com.example.Department.models.enums.Status;
import com.example.Department.models.responce.Message;
import com.example.Department.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UsersDao usersDao;
    private UsersMapper usersMapper = UsersMapper.INSTANCE;

    @Override
    public UserDto save(UserDto userDto) {
        User user = usersMapper.toEntity(userDto);
        user.setStatus(Status.ACTIVE);
        User userSaved = usersDao.save(user);
        return usersMapper.toDto(userSaved);
    }

    @Override
    public UserDto update(UserDto userDto) {
        boolean isExist = usersDao.existsById(userDto.getId());
        if (!isExist) {
            return null;
        }
        User user = usersMapper.toEntity(userDto);
        User userUpdate = usersDao.save(user);
        return usersMapper.toDto(userUpdate);
    }

    @Override
    public UserDto findById(Long id) {
        User user = usersDao.findById(id).orElse(null);
        return usersMapper.toDto(user);
    }

    @Override
    public ResponseEntity<?> delete(UserDto userDto) {
        User user = usersMapper.toEntity(userDto);
        user.setStatus(Status.INACTIVE);
       UserDto userDelete = update(usersMapper.toDto(user));
       if(userDelete == null){
           return new ResponseEntity<>(Message.of("Не найден пользователь"), HttpStatus.NOT_ACCEPTABLE);
       }
        return new ResponseEntity<>(Message.of("Пользователь заблокирован"),HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> findByEmail(String email) {
        User user = usersDao.findByEmail(email);
        return new ResponseEntity<>(Message.of("успешно"),HttpStatus.OK);

    }
}
