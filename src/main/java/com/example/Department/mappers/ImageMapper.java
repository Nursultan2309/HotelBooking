package com.example.Department.mappers;

import com.example.Department.models.dto.ImageDto;
import com.example.Department.models.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper extends BaseMapper<Image, ImageDto>{
 ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

}
