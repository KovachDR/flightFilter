package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FilterFlights {
    List<Flight> departureBeforeMomentTime(List<Flight> flights, LocalDateTime time);

    List<Flight> arrivalDateBeforeDepartureDate(List<Flight> flights);

    List<Flight> downtimeMoreTwoHours(List<Flight> flights);
}
