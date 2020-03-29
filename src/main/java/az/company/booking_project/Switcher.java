package az.company.booking_project;


import az.company.booking_project.controller.BookingController;
import az.company.booking_project.controller.FlightController;
import az.company.booking_project.controller.UserController;
import az.company.booking_project.dao.UserDao;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.entities.User;
import az.company.booking_project.services.UserService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Switcher {
    private FlightController flightController  =new FlightController();   ;
    private BookingController bookingController= new BookingController();  ;
    private UserController userController   =  new UserController();
    private UserService userService= new UserService();
    UserDao userDao= new UserDao();
    private DisplayMenu displayMenu  = new DisplayMenu();



    public void run() throws IOException, ClassNotFoundException {
        Flight.TimeTable();
        Scanner scanner = new Scanner(System.in);
        boolean command = true;
        while (command) {
            try{
            boolean command1 = false;
            displayMenu.visitor();
            String  menu0item = scanner.next();
            switch (menu0item) {
                case "1":
                    try {
                        System.out.println("Username:");
                        String username = scanner.next();
                        System.out.println("Password:");
                        String password = scanner.next();
                        if (!userService.check(username)) {
                            userController.getUser(new User(username, password));
                            System.out.println("You have successfully logged in");
                            command1=true;
                        }
                        else {
                            System.out.println("This user doesn't exist, please sign up");
                            command1=false;
                        }
                    }
                    catch (InputMismatchException ex){
                        System.out.println("Enter valid data");
                    }
                    break;
                case "2":
                    userController.SignUp();
                    break;
                case "3":
                    command = false;
                    System.out.println("Bye bye..Thank you for using our application");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            while (command1) {
                displayMenu.user();
                String menuItem = scanner.next();
                switch (menuItem) {

                    case "1":
                        flightController.GettAllFlights();
                        break;
                    case "2":
                        flightController.GetFlightsById();
                        break;
                    case "3":
                        boolean command2 = false;
                        try {
                            bookingController.SearchBooking();
                            break;
                        } catch (InputMismatchException im) {
                            System.out.println("Something went wrong");
                            command2 = false;
                        }

                    case "4":
                        bookingController.ShowMadeBookings();
                        break;
                    case "5":
                        bookingController.CancelBookings();
                        break;
                    case "6":
                        command1 = false;
                        System.out.println("Out of account!");
                        break;
                    default:
                        System.out.println("Invalid option! Enter option from menu please");
                        break;
                }
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid command, enter command from menu");
            }
        }
    }
}
