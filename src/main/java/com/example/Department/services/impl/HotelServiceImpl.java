package com.example.Department.services.impl;

import com.example.Department.dao.HotelDao;
import com.example.Department.mappers.*;
import com.example.Department.models.dto.*;
import com.example.Department.models.entity.Hotel;
import com.example.Department.models.enums.BedType;
import com.example.Department.models.responce.HotelFilterResponce;
import com.example.Department.models.responce.Message;
import com.example.Department.models.responce.RoomFilterResponce;
import com.example.Department.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired HotelDao hotelDao;
    @Autowired CityService cityService;
    @Autowired  ReviewService reviewService;
    @Autowired UserService userService;
    @Autowired RoomService roomService;
    @Autowired BookingService bookingService;
    @Autowired PriceService priceService;
    RoomMapper roomMapper = RoomMapper.INSTANCE;
    RoomCategotyMapper roomCategotyMapper = RoomCategotyMapper.INSTANCE;
    HotelMapper hotelMapper = HotelMapper.INSTANCE;
    CityMapper cityMapper = CityMapper.INSTANCE;
    PriceMapper priceMapper = PriceMapper.INSTANCE;
    @Override
    @Transactional
    public ResponseEntity<?> save(HotelDto hotelDto) {

//        UserDto managerSaved = userService.save(hotelDto.getManager());
//        hotelDto.setManager(managerSaved);
        Hotel savedHotel = hotelDao.save(hotelMapper.toEntity(hotelDto));
        return new ResponseEntity<>(hotelMapper.toDto(savedHotel), HttpStatus.OK);

    }


    @Override
    public ResponseEntity<?> update(HotelDto hotelDto) {
        boolean isExist = hotelDao.existsById(hotelDto.getId());
        if (!isExist) {
            return new ResponseEntity<>(Message.of("Hotel not found"), HttpStatus.NOT_ACCEPTABLE);
        }
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        Hotel hotelUpdate = hotelDao.save(hotel);
        return new ResponseEntity<>(hotelUpdate, HttpStatus.OK);
    }

    @Override
    public HotelDto findById(Long id) {
        Hotel hotel = hotelDao.findById(id).orElse(null);
        return hotelMapper.toDto(hotel);
    }

    @Override
    public ResponseEntity<?> deleteHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        hotel.setActive(false);
        ResponseEntity<?> deletedHotel = update(hotelMapper.toDto(hotel));
        if (deletedHotel.getStatusCode().equals(HttpStatus.OK)) {
            return new ResponseEntity<>(deletedHotel, HttpStatus.OK);
        }
        return new ResponseEntity<>(Message.of("Возникло ошибка при удаление"), HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseEntity<?> findAllByCityAndByRating(Long cityId) {
        CityDto cityDto = cityService.findById(cityId);
        List<Hotel> hotels = hotelDao.findAllByCityAndCurrentScore(cityMapper.toEntity(cityDto));
        if (hotels.size() != 0) {
            return ResponseEntity.ok(hotelMapper.toDtoList(hotels));
        }
        return new ResponseEntity<>(Message.of("Отели по этому номеру не найдены"), HttpStatus.NOT_FOUND);
    }

    @Override
    public List<HotelDto> findAllHotelsByCity(Long cityId) {
        CityDto cityDto = cityService.findById(cityId);
        if(cityDto != null){
            List<Hotel> hotels = hotelDao.findAllByCity(cityDto.getId());
            if(!hotels.isEmpty()) {
                return hotelMapper.toDtoList(hotels);
            }else {
                return null;
            }
        }else {
        return null;
        }
        }

    @Override
    public ResponseEntity<?> filter(Long cityId, LocalDate checkInDate, LocalDate checkOutDate, int questAmount, BedType bedType) {


        // получили все отели по городу и наличию нужного типа комнаты
        List<Hotel> hotels = hotelDao.findAllByCityAndBedType(cityId, bedType);
        List<HotelFilterResponce> filteredHotels = new ArrayList<>();

        List<Hotel> availabeHotels = new ArrayList<>();
        hotels.stream().forEach(hotel -> {
            // получили все номера отеля по типу комнаты
            List<RoomDto> rooms = roomService.findAllRoomsByHotel(hotel, bedType, questAmount );
            List<RoomDto> availableRooms = new ArrayList<>();
            System.out.println(rooms.size());
            rooms.stream().forEach(room -> {
                List<BookingDto> bookings = bookingService.findAllByRoomAndActive(room);
                if (bookings.isEmpty()) {

                    availableRooms.add(room);
                } else {
                    AtomicBoolean isBooked = new AtomicBoolean(false);
                    bookings.stream().forEach(z-> {
                        if (checkInBooked(z, checkInDate, checkOutDate)) {
                            System.out.println("Room is booked");
                          isBooked.set(true);
                        }
                    });

                    if(isBooked.equals(false)){
                        availableRooms.add(room);
                    }
                }
            });
            if(!availableRooms.isEmpty()){
                availabeHotels.add(hotel);
                HotelFilterResponce responce = formHotelResponce(hotel,availableRooms,checkInDate, checkOutDate);
                System.out.println(responce);
                filteredHotels.add(responce);

            }
        });
return new ResponseEntity<>(filteredHotels, HttpStatus.OK);
    }


    @Override
    public List<HotelDto> findAll() {
        return hotelMapper.toDtoList(hotelDao.findAll());
    }

    @Override
    public void countCurrentScore() {
        List<HotelDto> hotelDtos = findAll();
        hotelDtos.stream().forEach(x -> {
            List<ReviewDto> review = reviewService.findAllByHotelAndActive(x.getId());
            Double sum = review.stream().mapToDouble(ReviewDto::getScore).sum();
            Double currentScore = Math.round((sum / review.size()) / 10.0) * 10.0;
            // на случае если double округление не сработает
            String result = String.format("%.1f", currentScore);
            x.setCurrentScore(currentScore);
            update(x);
        });
    }

    private boolean checkInBooked(BookingDto bookingDto, LocalDate startDate, LocalDate endDate) {
        if (startDate.equals(bookingDto.getCheckInDate())
                || startDate.equals(bookingDto.getCheckOutDate())
                || (startDate.isAfter(bookingDto.getCheckInDate()) && endDate.isBefore(bookingDto.getCheckOutDate()))
                || endDate.equals(bookingDto.getCheckInDate())
                || endDate.equals(bookingDto.getCheckOutDate())
                || (endDate.isAfter(bookingDto.getCheckInDate()) && endDate.isBefore(bookingDto.getCheckOutDate()))
                || (startDate.isBefore(bookingDto.getCheckInDate()) && endDate.isAfter(bookingDto.getCheckOutDate()))
        ){
            return true;
        } else {
            return false;
        }
    }

    private HotelFilterResponce formHotelResponce(Hotel hotel, List<RoomDto> roomDtos, LocalDate checkIn, LocalDate checkOut) {
          HotelFilterResponce hotelResponce = new HotelFilterResponce();
          hotelResponce.setId(hotel.getId());
          hotelResponce.setAddress(hotel.getAddress());
          hotelResponce.setCurrentScore(hotel.getCurrentScore());
          hotelResponce.setDescription(hotel.getDescription());
          hotelResponce.setEmail(hotel.getEmail());
          hotelResponce.setPhone(hotel.getPhone());
          hotelResponce.setPhotos(hotel.getPhotos());


        List<RoomFilterResponce> roomResponces = new ArrayList<>();
        roomDtos.stream().forEach(room-> {
                    PriceDto priceForCheckIn = priceService.findPriceByRoom(room.getRoomCategory(), checkIn);
                    PriceDto priceForCheckOut = priceService.findPriceByRoom(room.getRoomCategory(), checkOut);
                    if (priceForCheckIn != null && priceForCheckOut != null) {

                        if (priceForCheckIn.getPrice() == priceForCheckOut.getPrice()) {

                            Long daysBetween = DAYS.between(checkIn, checkOut) + 1;
                            float totalSum = priceForCheckIn.getPrice() * daysBetween;

                            RoomFilterResponce roomFilterResponce = RoomFilterResponce.builder()
                                    .bedType(room.getBedType())
                                    .capacity(room.getCapacity())
                                    .checkInDate(checkIn)
                                    .checkOutDate(checkOut)
                                    .id(room.getId())
                                    .square(room.getSquare())
                                    .typeOfView(room.getTypeOfView())
                                    .wifi(room.isWifi())
                                    .totalSum(totalSum)
                                    .build();
                            roomResponces.add(roomFilterResponce);
                        }else{

                            Long daysBetween = DAYS.between(checkIn, priceForCheckIn.getEndDate())+ 1;
                            float sumBeginning = daysBetween * priceForCheckIn.getPrice();
                            Long daysBetween2 = DAYS.between(priceForCheckOut.getStartDate(),checkOut)+ 1;
                            float sumEnding  = daysBetween2 * priceForCheckOut.getPrice();
                            float totalSum = sumBeginning + sumEnding;

                            RoomFilterResponce roomFilterResponce = RoomFilterResponce.builder()
                                    .bedType(room.getBedType())
                                    .capacity(room.getCapacity())
                                    .checkInDate(checkIn)
                                    .checkOutDate(checkOut)
                                    .id(room.getId())
                                    .square(room.getSquare())
                                    .typeOfView(room.getTypeOfView())
                                    .wifi(room.isWifi())
                                    .totalSum(totalSum)
                                    . build();

                            roomResponces.add(roomFilterResponce);
                        }
                    }
                });
        hotelResponce.setAvailableRooms(roomResponces);
        return hotelResponce;
    }

}
