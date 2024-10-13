package com.example.alpha.hotel.mapper;

import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.hotel.model.HotelDTO;

public class HotelMapper {
    public static HotelDTO toDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getId());
        dto.setCity(hotel.getCity());
        dto.setDescription(hotel.getDescription());
        dto.setStandard(hotel.getStandard());
        dto.setName(hotel.getName());
        return dto;
    }
    public static Hotel toEntity(HotelDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setCity(dto.getCity());
        hotel.setName(dto.getName());
        hotel.setStandard(dto.getStandard());
        hotel.setDescription(dto.getDescription());
        return hotel;
    }
}