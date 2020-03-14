package az.company.booking_project.controller;

import az.company.booking_project.services.BookingService;

import java.io.IOException;

public class BookingController {
    private BookingService bookingService=new BookingService();
    public void makeBooking(int tickets){
        bookingService.makeBooking(tickets);

    }

    public void showMyBookings() throws IOException, ClassNotFoundException {
        bookingService.showMyBookings().forEach(System.out::println);
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingService.cancelBooking(cancelID);
    }
}
