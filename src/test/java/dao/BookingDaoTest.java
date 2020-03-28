package dao;

import az.company.booking_project.dao.BookingDao;
import az.company.booking_project.entities.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class BookingDaoTest extends BookingDao {
    private static int count = 0;

    @org.junit.Test
    public void findAll() {

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
        Passenger passenger= new Passenger("Nazrin","Aghayeva");
        Passenger passenger1= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers= new ArrayList<>();
        passengers.add(passenger);
        passengers.add(passenger1);
        Booking booking= new Booking(count, passengers);
        create(booking);
        List<Booking> bookings= new ArrayList<>();
        bookings.add(booking);

        assertEquals(bookings, getAll());
    }

    @org.junit.Test
    public void findById() {
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
        Passenger passenger= new Passenger("Nazrin","Aghayeva");
        Passenger passenger1= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers= new ArrayList<>();
        passengers.add(passenger);
        passengers.add(passenger1);
        Booking booking= new Booking(count, passengers);
        create(booking);
        List<Booking> bookings= new ArrayList<>();
        bookings.add(booking);
        Optional<Booking> found = bookings.stream().filter(booking1 -> booking.getId() == 1).findFirst();

        assertEquals(found, getById(1));
    }

    @org.junit.Test
    public void add() {
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
        Passenger passenger= new Passenger("Nazrin","Aghayeva");
        Passenger passenger1= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers= new ArrayList<>();
        passengers.add(passenger);
        passengers.add(passenger1);
        Booking booking= new Booking(count, passengers);
        assertTrue(create(booking));

    }

    @org.junit.Test
    public void remove() throws IOException, ClassNotFoundException {
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
        Passenger passenger= new Passenger("Nazrin","Aghayeva");
        Passenger passenger1= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers= new ArrayList<>();
        passengers.add(passenger);
        passengers.add(passenger1);
        Booking booking= new Booking(count, passengers);
        assertTrue(delete(1));
    }

}