package com.example.alpha.statistic.model;

import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Statistic {

    @Autowired
    private TourRepository tourRepository;

    public long getTotalToursForMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();
        return tourRepository.countByStartDateBetween(startDate, endDate);
    }

    public List<Tour> getMostBookedTours() {
        List<Tour> allTours = tourRepository.findAll();
        Map<Tour, Long> tourCount = allTours.stream()
                .collect(Collectors.groupingBy(tour -> tour, Collectors.counting()));

        long maxCount = tourCount.values().stream().max(Long::compare).orElse(0L);
        return tourCount.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



}