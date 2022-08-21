package com.example.Department.mappers;

import com.example.Department.models.dto.BookingDto;
import com.example.Department.models.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper extends BaseMapper<Booking, BookingDto> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);


}
