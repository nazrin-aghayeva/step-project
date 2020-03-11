package project.booking.service;


import project.booking.entity.ArrivalCity;
import project.booking.entity.DepartureCity;
import project.booking.entity.Flight;
import project.booking.entity.Passenger;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    List<Flight> findAllFlights();

    Optional<Flight> findFlightByFlightId(int flightId);

    List<Passenger> findPassengersOfFlight(int flightId);

    List<Flight> findFlightsMatchedByCriteria(ArrivalCity origin, DepartureCity destination, LocalDate departure, int passengers);

    void create(Flight flight);

    void remove(int flightId);

    void save();

    void load();
}
