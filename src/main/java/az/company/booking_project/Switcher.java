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
private DisplayMenu displayMenu =new DisplayMenu();
    private FlightController flightController = new FlightController();
    private BookingController bookingController = new BookingController();
    private UserController userController = new UserController();

    public void run() throws IOException, ClassNotFoundException {
        Flight.TimeTable();
        Scanner scanner = new Scanner(System.in);
        boolean command = true;
        while (command) {
            boolean command1=false;
            displayMenu.visitor();
            int menu0item = scanner.nextInt();
            switch (menu0item) {
                case 1:
                    try {
                        System.out.println("Username:");
                        String username = scanner.next();
                        System.out.println("Password:");
                        String password = scanner.next();
                        userController.getUser(new User(username, password));
                        command1=true;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid input! Please enter menu item!");
                    }catch (Exception e) {
                        System.out.println("User doesn't exist, please sign up");
                        command1 = false;
                    }
                    break;
                case 2:
                    System.out.println("Username:");
                    String usernamereg = scanner.next();
                    System.out.println("Password:");
                    String passwordreg = scanner.next();
                    userController.creatNewUser(new User(usernamereg,passwordreg));break;
                case 3:command=false;break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }


            while (command1) {

                displayMenu.user();
                int menuItem = scanner.nextInt();
                switch (menuItem) {

                    case 1:
                        flightController.getAll();
                        break;
                    case 2:
                        System.out.print("ID of flight: ");
                        int id = scanner.nextInt();
                        flightController.getById(id);
                        break;
                    case 3:
                        boolean command2 = true;
                        int tickets = 0;
                        try {
                            System.out.println("Arrival city:");
                            String city = scanner.next().toUpperCase();
                            System.out.println("Date (mm/dd/yyyy):");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            String date= scanner.next();
                            System.out.println("Number of tickets:");
                            tickets = scanner.nextInt();
                            flightController.search(new Flight(ArrivalCity.valueOf(city),LocalDate.parse(date, formatter).atStartOfDay()));
                        } catch (InputMismatchException im) {
                            System.out.println("Smthn go wrong");
                            command2 = false;
                        }
//                        } catch (Exception ex) {
//                            System.out.println("Date format is not true!");
//                            command2 = false;
//                        }

                        while (command2) {
                            displayMenu.book();
                            int press = scanner.nextInt();
                            switch (press) {
                                case 1:
                                    bookingController.makeBooking(tickets);
                                    break;
                                case 2:
                                    command2 = false;
                                    break;
                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }
                        }
                        break;
                    case 4:
                        bookingController.showMyBookings();
                        break;
                    case 5:
                        System.out.println("Booking ID: ");
                        int cancelID = scanner.nextInt();
                        bookingController.cancelBooking(cancelID);
                        break;
                    case 6:
                        command1 = false;
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            }
        }
    }
}
