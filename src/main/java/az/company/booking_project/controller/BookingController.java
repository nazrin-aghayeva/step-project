package az.company.booking_project.controller;

import az.company.booking_project.Exceptions.BookingException;
import az.company.booking_project.services.BookingService;

import java.io.IOException;

public class BookingController {
    private BookingService bookingService=new BookingService();
    public void makeBooking(int tickets){
        bookingService.makeBooking(tickets);

    }

    public void showMyBookings() {
        try {
            bookingService.showMyBookings().forEach(System.out::println);
        }
        catch ( IOException | ClassNotFoundException e){
            throw new BookingException("Booking is not found please check that you made booking");
        }
    }

    public void cancelBooking(int cancelID)  {
        try {
            bookingService.cancelBooking(cancelID);
            System.out.println("Booking was deleted.");
        }
        catch (IOException | ClassNotFoundException e){
            throw new BookingException("Booking is not found please enter right ID to cancel booking!" );
        }
    }
}
