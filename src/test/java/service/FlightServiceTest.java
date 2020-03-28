package service;

import az.company.booking_project.dao.FlightDao;
import az.company.booking_project.entities.*;
import az.company.booking_project.services.FlightService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest extends FlightService {
public static int count=0;
    @Test
    void findAll() throws IOException, ClassNotFoundException {
        Flight flight1= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.getRandomCity(),
                ArrivalCity.AMSTERDAM,
                45,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(4)
        );
        create(flight1);
        List<Flight> flights= new ArrayList<>();
        flights.add(flight1);
        assertEquals(flights, findAllFlights());
    }

    @Test
    void getById() throws IOException, ClassNotFoundException {
        Flight flight1= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.getRandomCity(),
                ArrivalCity.AMSTERDAM,
                45,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(4)
        );
        create(flight1);
        List<Flight> flights= new ArrayList<>();
        flights.add(flight1);
        assertEquals(Optional.of(flight1),getById(flight1.getId()));

    }

    @Test
    void search() {
    }
}