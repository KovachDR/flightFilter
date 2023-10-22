package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FilterFlights;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlightsImpl implements FilterFlights {
    @Override
    public List<Flight> departureBeforeMomentTime(List<Flight> flights, LocalDateTime time) {
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (Segment segment : segments) {
                if (segment.getDepartureDate().isBefore(time)) {
                    filterFlights.add(flight);
                }
            }
        }
        return filteredList(filterFlights);
    }

    @Override
    public List<Flight> arrivalDateBeforeDepartureDate(List<Flight> flights) {
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            for (Segment segment : segments) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    filterFlights.add(flight);
                }
            }
        }
        return filteredList(filterFlights);
    }

    @Override
    public List<Flight> downtimeMoreTwoHours(List<Flight> flights) {
        List<Flight> filterFlights = new ArrayList<>();
        int statedDowntime = 2;

        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();

            int downtime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    downtime += Math.abs(Duration.between(segments.get(i).getArrivalDate(),
                            segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (downtime > statedDowntime) {
                    filterFlights.add(flight);
                }
            }
        }
        return filteredList(filterFlights);
    }

    private List<Flight> filteredList(List<Flight> flights) {
        return flights.stream().distinct().collect(Collectors.toList());
    }
}
