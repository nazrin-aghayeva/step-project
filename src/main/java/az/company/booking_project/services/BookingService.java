package az.company.booking_project.services;


import az.company.booking_project.dao.BookingDao;
import az.company.booking_project.entities.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BookingService {
    private BookingDao bookingDao=new BookingDao();
    Database database;
    Flight flight;

    public boolean makeBooking(int tickets ) {
        return bookingDao.create(bookingDao.makeBooking(tickets));
    }




    public List<Booking> showMyBookings() throws IOException, ClassNotFoundException {
        return bookingDao.getAll();
    }

    public Optional<Booking> findBookingById(int bookingId) {
        return bookingDao.getById(bookingId);
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingDao.delete(cancelID);
    }
    public boolean createBooking(int flight_id, List<Passenger> passenger) {
        bookingDao.create(new Booking(flight_id, passenger));
       return database.writeToFileBooking();
    }
}
