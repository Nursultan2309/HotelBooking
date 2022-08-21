package com.example.Department.dao;

import com.example.Department.models.entity.City;
import com.example.Department.models.entity.Hotel;
import com.example.Department.models.enums.BedType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Long> {
   @Query(value = "select h from tb_hotel h where h.city_id = ?1 order by h.current_score DESC", nativeQuery = true)
   List<Hotel> findAllByCityAndCurrentScore(City city);

   @Query(value = "select * from tb_hotel h where h.city_id = :id and exists (select * from tb_room r where r.hotel_id = h.id and r.bed_type = :#{#bedType.name()})", nativeQuery = true)
   List<Hotel> findAllByCityAndBedType(@Param("id") Long cityId, @Param("bedType") BedType bedType);

   @Query(value = "select * from tb_hotel h where h.city_id = ?1 ORDER BY h.current_score DESC",nativeQuery = true)
   List<Hotel> findAllByCity(Long cityId);
}