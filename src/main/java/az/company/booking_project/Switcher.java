package az.company.booking_project;


import az.company.booking_project.controller.BookingController;
import az.company.booking_project.controller.FlightController;
import az.company.booking_project.controller.UserController;
import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.entities.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switcher {
    private FlightController flightController = new FlightController();
    private BookingController bookingController = new BookingController();
    private UserController userController = new UserController();
    private DisplayMenu displayMenu = new DisplayMenu();


    public void run() throws IOException, ClassNotFoundException {
        Flight.TimeTable();
        Scanner scanner = new Scanner(System.in);
        boolean command = true;
        while (command) {
            boolean command1 = false;
            displayMenu.visitor();
            int menu0item = scanner.nextInt();
            switch (menu0item) {
                case 1:
                    try {
                        userController.LogIn();
                        command1 = true;
                    } catch (Exception e) {
                        System.out.println("User doesn't exist");
                        command1 = false;
                    }
//
                    break;
                case 2:
                    userController.SignUp();
                    break;
                case 3:
                    command = false;
                    System.out.println("Bye bye..Thank you for using our application");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            while (command1) {
                displayMenu.user();
                int menuItem = scanner.nextInt();
                switch (menuItem) {

                    case 1:
                        flightController.GettAllFlights();
                        break;
                    case 2:
                        flightController.GetFlightsById();
                        break;
                    case 3:
                        boolean command2 = false;
                        try {
                            bookingController.SearchBooking();
                            break;
                        } catch (InputMismatchException im) {
                            System.out.println("Something went wrong");
                            command2 = false;
                        }

                    case 4:
                        bookingController.ShowMadeBookings();
                        break;
                    case 5:
                        bookingController.CancelBookings();
                        break;
                    case 6:
                        command1 = false;
                        System.out.println("Out of account!");
                        break;
                    default:
                        System.out.println("Invalid option! Enter option from menu please");
                        break;
                }
            }
        }
    }
}
