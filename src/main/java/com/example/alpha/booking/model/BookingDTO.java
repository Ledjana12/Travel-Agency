package com.example.alpha.booking.model;

import java.util.Date;
import java.util.List;

public class BookingDTO {
    private Long bookingId;
    private Long tourId;
    private List<String> participantsData;
    private Date bookingDate;
    private double amount;
    private int adults;
    private int children;
    private String status;

    public long getBookingId (){
        return bookingId;
    }
    public void setBookingId(Long bookingId){
        this.bookingId = bookingId ;
    }
    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public List<String> getParticipantsData() {
        return participantsData;
    }

    public void setParticipantsData(List<String> participantsData) {
        this.participantsData = participantsData;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}