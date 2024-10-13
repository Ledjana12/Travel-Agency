package com.example.alpha.booking.mapper;

import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.model.BookingStatus;
import com.example.alpha.tour.model.Tour;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBooking_id());
        bookingDTO.setTourId(booking.getTour().getTour_id());
        bookingDTO.setParticipantsData(booking.getParticipants_data());
        bookingDTO.setBookingDate(booking.getBooking_date());
        bookingDTO.setAmount(booking.getAmount());
        bookingDTO.setAdults(booking.getAdults());
        bookingDTO.setChildren(booking.getChildren());
        bookingDTO.setStatus(booking.getStatus().name());

        return bookingDTO;
    }

    public static Booking toEntity(BookingDTO bookingDTO, Tour tour) {
        if (bookingDTO == null) {
            return null;
        }

        Booking booking = new Booking();
        booking.setBooking_id(bookingDTO.getBookingId());
        booking.setTour(tour); // Tour must be fetched in the service layer
        booking.setParticipants_data(bookingDTO.getParticipantsData());
        booking.setBooking_date(bookingDTO.getBookingDate());
        booking.setAmount(bookingDTO.getAmount());
        booking.setAdults(bookingDTO.getAdults());
        booking.setChildren(bookingDTO.getChildren());
        booking.setStatus(BookingStatus.valueOf(bookingDTO.getStatus()));

        return booking;
    }
}