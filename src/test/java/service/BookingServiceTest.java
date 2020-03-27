package service;

import az.company.booking_project.entities.*;
import az.company.booking_project.services.BookingService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest extends BookingService {
public static int count=0;
    @Test
    void findBookingById() {
        Flight flight1= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.KIEV,
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

        Flight flight2= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.KIEV,
                ArrivalCity.AMSTERDAM,
                45,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(4)
        );
        Passenger passenger2= new Passenger("Nazrin","Aghayeva");
        Passenger passenger3= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers1= new ArrayList<>();
        passengers1.add(passenger2);
        passengers1.add(passenger3);


        Booking booking1= new Booking(count, passengers1);
        Booking booking= new Booking(count, passengers);

        createBooking(count,passengers1);
        createBooking(count,passengers);

        List<Booking> bookings= new ArrayList<>();
        bookings.add(booking);
        bookings.add(booking1);

        Optional<Booking> foundBookings = bookings.stream()
                .filter(booking2 -> booking2.getId() == booking1.getId())
                .findFirst();
        assertEquals(foundBookings, findBookingById(booking1.getId()+2));
    }

    @Test
    void createBooking() {
        Flight flight2= new Flight(
                ++count,
                Airline.LUFTHANSA,
                Airline.AIR_FRANCE.getCode()+112,
                DepartureCity.KIEV,
                ArrivalCity.AMSTERDAM,
                45,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(4)
        );
        Passenger passenger2= new Passenger("Nazrin","Aghayeva");
        Passenger passenger3= new Passenger("Zeynab","Mammadova");
        List<Passenger> passengers1= new ArrayList<>();
        passengers1.add(passenger2);
        passengers1.add(passenger3);

assertTrue(createBooking(count,passengers1));

    }
}