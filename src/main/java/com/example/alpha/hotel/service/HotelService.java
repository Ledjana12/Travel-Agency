package com.example.alpha.hotel.service;

import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.hotel.model.HotelDTO;
import com.example.alpha.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(HotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        return HotelMapper.toDTO(hotel);
    }

    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = HotelMapper.toEntity(hotelDTO);
        Hotel savedHotel = hotelRepository.save(hotel);
        return HotelMapper.toDTO(savedHotel);
    }

    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        existingHotel.setName(hotelDTO.getName());
        existingHotel.setCity(hotelDTO.getCity());
        Hotel updatedHotel = hotelRepository.save(existingHotel);
        return HotelMapper.toDTO(updatedHotel);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
        hotelRepository.deleteById(id);
    }
}
