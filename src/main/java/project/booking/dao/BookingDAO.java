package project.booking.dao;

import project.booking.dao.DAO;
import project.booking.entity.Booking;
import project.booking.entity.Flight;
import project.booking.entity.User;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BookingDAO implements DAO<Booking> {


    private File file;
    private List<Booking> bookings;
    private DAOBin<Booking> io;

    public BookingDAO() {
        this(new File("./db", "bookings.txt"));
    }

    public BookingDAO(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.file = file;
        this.bookings = new ArrayList<>();
        this.io = new DAOBin<>(file, bookings);
    }

    @Override
    public List<Booking> findAll() {
        return bookings;
    }

    @Override
    public Optional<Booking> findById(int id) {
        return bookings.stream().filter(booking -> booking.bookingId == id).findFirst();
    }

    @Override
    public boolean create(Booking booking) {
        if (booking == null) throw new IllegalArgumentException("Null booking.");
        if (bookings.contains(booking)) return false;
        bookings.add(booking);
        booking.flight.addPassenger(booking.passenger);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Optional<Booking> chosen = bookings.stream()
                .filter(booking -> booking.bookingId == id)
                .findFirst();
        if (chosen.isPresent()) {
            Flight flight = chosen.get().flight;
            flight.removePassenger(chosen.get().passenger);
            boolean removed = bookings.remove(chosen.get());
            return removed;
        }
        return false;
    }


    public void load() {
        io.load();
    }

    public void save() {
        io.save();
    }
}
