package com.example.Department.mappers;

import com.example.Department.models.dto.RoomCategoryDto;
import com.example.Department.models.entity.RoomCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomCategotyMapper extends BaseMapper<RoomCategory, RoomCategoryDto>{
    RoomCategotyMapper INSTANCE = Mappers.getMapper(RoomCategotyMapper.class);

}
