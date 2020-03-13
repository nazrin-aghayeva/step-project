package booking_project.services;


import az.company.booking_project.Dao.BookingDao;
import az.company.booking_project.entities.Booking;

import java.io.IOException;
import java.util.List;

public class BookingService {
    private BookingDao bookingDao=new BookingDao();


    public boolean makeBooking(int tickets ) {
       return bookingDao.create(bookingDao.makeBooking(tickets));
    }

    public List<Booking> showMyBookings() throws IOException, ClassNotFoundException {
        return bookingDao.getAll();
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingDao.delete(cancelID);
    }
}
