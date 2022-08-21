package com.example.Department.mappers;

import com.example.Department.models.dto.RoomDto;
import com.example.Department.models.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<Room, RoomDto> {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
}
