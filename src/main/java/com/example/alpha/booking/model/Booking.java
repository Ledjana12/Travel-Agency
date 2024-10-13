package com.example.alpha.booking.model;

import com.example.alpha.tour.model.Tour;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ElementCollection
    private List<String> participants_data;

    private Date booking_date;
    private double amount;
    private int adults;
    private int children;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<String> getParticipants_data() {
        return participants_data;
    }

    public void setParticipants_data(List<String> participants_data) {
        this.participants_data = participants_data;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setParticipantsData(List<String> participantsData) {
    }

    public void setBookingDate(Date date) {
    }

    @Column(name = "booking_date")
    

    public Date getBookingDate() {
        return booking_date ;
    }
}