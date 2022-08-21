package com.example.Department.mappers;

import com.example.Department.models.dto.UserDto;
import com.example.Department.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper extends BaseMapper<User, UserDto> {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);
}
