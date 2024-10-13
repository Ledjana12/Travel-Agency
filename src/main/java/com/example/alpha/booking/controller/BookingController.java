package com.example.alpha.booking.controller;

import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book-tour")
    public BookingDTO bookTour(@RequestParam Long tourId,
                               @RequestParam List<String> participantsData,
                               @RequestParam int adults,
                               @RequestParam int children) {
        return bookingService.bookTour(tourId, participantsData, adults, children);
    }

    @PostMapping("/cancel/{id}")
    public BookingDTO cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }

    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

}