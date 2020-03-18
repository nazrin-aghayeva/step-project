package az.company.booking_project.controller;

import az.company.booking_project.DisplayMenu;
import az.company.booking_project.Exceptions.BookingException;
import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.services.BookingService;
import az.company.booking_project.services.FlightService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingController {
    private BookingService bookingService=new BookingService();
    private FlightService flightService= new FlightService();
    private DisplayMenu displayMenu =new DisplayMenu();
    Scanner scanner = new Scanner(System.in);

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

    public void SearchBooking() {
        boolean command2 = true;
        try
        {
            System.out.println("Please enter arrival city:");
            String city = scanner.next().toUpperCase();
            System.out.println("Please enter arrival date (mm/dd/yyyy):");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String date = scanner.next();
            System.out.println("Please enter number of tickets:");
            int tickets = scanner.nextInt();
            flightService.search(new Flight(ArrivalCity.valueOf(city), LocalDate.parse(date, formatter).atStartOfDay()));
            while (command2) {
                displayMenu.book();
                String press = scanner.next();
                switch (press) {
                    case "1":
                        bookingService.makeBooking(tickets);
                        System.out.println("Your booking was saved!");
                        break;
                    case "2":
                        command2 = false;
                        break;
                    default:
                        System.out.println("Invalid option! Enter option from menu please");
                        break;
                }
            }
        }
        catch (Exception ex) {
            System.out.println("Date format is not right!");
            command2 = false;
            }
    }
}
