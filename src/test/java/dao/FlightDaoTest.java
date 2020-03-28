package dao;

import az.company.booking_project.dao.FlightDao;
import az.company.booking_project.entities.Airline;
import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.DepartureCity;
import az.company.booking_project.entities.Flight;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FlightDaoTest extends FlightDao {
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

        List<Flight> flights= new ArrayList<>();
        flights.add(flight1);
        create(flight1);
        assertEquals(flights,getAlls());
    }

    @Test
    void FindById() throws IOException, ClassNotFoundException {
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
        assertEquals(Optional.of(flight1),getById(flight1.getId()));
    }

    @Test
    void add() {
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
        assertTrue(create(flight1));
    }

    @Test
    void remove() throws IOException, ClassNotFoundException {
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
        assertTrue(delete(flight1.getId()));
    }
}