package com.example.alpha.booking.service;

import com.example.alpha.booking.mapper.BookingMapper;
import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.model.BookingStatus;
import com.example.alpha.booking.repository.BookingRepository;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.model.TourDTO;
import com.example.alpha.tour.repository.TourRepository;
import com.example.alpha.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourService tourService;

    @Transactional
    public BookingDTO bookTour(Long tourId, List<String> participantsData, int adults, int children) {
        // Fetch the tour
        Tour tour = tourRepository.findById(tourId).orElseThrow();

        // Check availability
        if (!tourService.hasAvailability(tour, adults, children)) {
            // Insufficient seats available, return null or throw an exception
            return null;
        }

        // Calculate total amount
        double totalAmount = tourService.calculatePrice(tourId, adults, children);
        if (totalAmount <= 0) {
            // Invalid price calculation, return null or throw an exception
            return null;
        }

        // Create the booking entity
        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setParticipantsData(participantsData);
        booking.setBookingDate(new Date());
        booking.setAmount(totalAmount);
        booking.setAdults(adults);
        booking.setChildren(children);
        booking.setStatus(BookingStatus.IN_PROCESS);

        // Save the booking
        booking = bookingRepository.save(booking);

        // Update availability
        tourService.updateAvailability(tour, adults, children);

        // Update booking status to booked
        booking.setStatus(BookingStatus.BOOKED);
        bookingRepository.save(booking);

        // Convert booking entity to DTO and return
        return BookingMapper.toDTO(booking);
    }

    public BookingDTO cancelBooking(Long id) {
        // Retrieve the booking by its ID
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Check if the booking is already cancelled
        if (booking.getStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Booking is already cancelled");
        }
        // Update the status to cancelled
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

        // Update the availability in the tour
        Tour tour = booking.getTour();
        tour.setAdultSeatsAvailable(tour.getAdultSeatsAvailable() + booking.getAdults());
        tour.setChildPlacesAvailable(tour.getChildPlacesAvailable() + booking.getChildren());
        tourService.updateTour(tour);

        // Convert the updated booking entity to DTO and return
        return BookingMapper.toDTO(booking);

    }
    @Transactional
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return BookingMapper.toDTO(booking);
    }
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(BookingMapper::toDTO).collect(Collectors.toList());
    }
}