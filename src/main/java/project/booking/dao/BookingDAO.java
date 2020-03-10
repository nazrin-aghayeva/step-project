package project.booking.dao;

import project.booking.entity.Booking;
import project.booking.entity.Flight;
import project.booking.entity.User;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookingDAO implements DAO<Booking> {
    private Map<Flight, Booking> bookings = new HashMap<>();


    @Override
    public Booking get(int id) {

    }

    @Override
    public List<Booking> getAll() {
        return null;
    }

    @Override
    public void create(Booking booking) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void Write() throws FileNotFoundException {

    }

    @Override
    public void Read() {

    }
}
