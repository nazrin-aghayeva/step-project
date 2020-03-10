package project.booking.dao;

import project.booking.entity.Booking;
import project.booking.entity.Flight;
import project.booking.entity.User;

import java.io.*;
import java.util.*;

public class BookingDAO implements DAO<Booking> {
    private Map<Integer, Booking> bookings = new HashMap<>();
    File bookingFile= new File("booking.txt");

    @Override
    public Booking get(int id) {
        return bookings.get(id);
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(bookings.values());
    }

    @Override
    public void create(Booking booking) {
        bookings.put(booking.bookingId,booking);
    }

    @Override
    public void delete(int id) {
        bookings.remove(id);
        Write();
    }

    @Override
    public void Write() {
        try(FileOutputStream fos= new FileOutputStream(bookingFile)){
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(bookings);
        }
        catch (IOException ex){
            System.out.println("Smth went wrong file is not found");
        }
    }

    @Override
    public void Read() {
        try (FileInputStream fis = new FileInputStream(bookingFile)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookings = (Map<Integer, Booking>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Smth went wrong file from user is not loaded");
        }
    }
}
