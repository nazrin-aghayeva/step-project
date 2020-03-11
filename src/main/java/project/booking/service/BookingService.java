package project.booking.service;


import project.booking.entity.Booking;
import project.booking.entity.Flight;
import project.booking.entity.Passenger;
import project.booking.entity.User;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> findAllBookings();
    List<Booking> findAllBookingsOfPassengerById(int passengerId);
    List<Booking> findAllBookingsOPassengerByName(String name);
    List<Booking> findAllBookingsOfUserById(int userId);
    List<Booking> findAllBookingsOfUserByName(String name);
    Optional<Booking> findBookingById(int bookingId);
    void cancelBooking(int bookingId);
    void createBooking(Flight flight, Passenger passenger, User user);
    void save();
    void load();
}
