package com.example.alpha.statistic.controller;

import com.example.alpha.statistic.model.Statistic;
import com.example.alpha.tour.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticController {

    @Autowired
    private Statistic statistic;

    @GetMapping("/statistics/total-tours-month")
    public long getTotalToursForMonth(@RequestParam int year, @RequestParam int month) {
        return statistic.getTotalToursForMonth(year, month);
    }

    @GetMapping("/statistics/most-booked-tours")
    public List<Tour> getMostBookedTours() {
        return statistic.getMostBookedTours();
    }
}