package com.example.Department.mappers;

import com.example.Department.models.dto.BookingHistoryDto;
import com.example.Department.models.entity.BookingHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingHistoryMapper extends BaseMapper<BookingHistory, BookingHistoryDto> {
    BookingHistoryMapper INSTANCE = Mappers.getMapper(BookingHistoryMapper.class);

}
