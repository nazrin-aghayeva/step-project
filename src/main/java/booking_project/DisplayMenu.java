package booking_project;


import az.company.booking_project.controller.BookingController;
import az.company.booking_project.controller.FlightController;
import az.company.booking_project.controller.UserController;

public class DisplayMenu {
    private FlightController flightController = new FlightController();
    private BookingController bookingController = new BookingController();
    private UserController userController = new UserController();

    void user() {
        StringBuilder sb = new StringBuilder();
        sb.append(" _________________________________________________________________________ \n");
        sb.append("|                        FLIGHT RESERVATION SYSTEM                        |\n");
        sb.append("|            Please choose one of the options below to continue.          |\n");
        sb.append("|_________________________________________________________________________|\n");
        sb.append("|                         1. View Timetable                               |\n");
        sb.append("|                         2. View Flight Details                          |\n");
        sb.append("|                         3. Search and Bookings                          |\n");
        sb.append("|                         4. My Bookings                                  |\n");
        sb.append("|                         5. Cancel a Booking                             |\n");
        sb.append("|                         6. Exit                                         |\n");
        sb.append("|_________________________________________________________________________|\n");
        sb.append(">>> Your selection: ");
        System.out.println(sb);
    }

    void book() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" _________________________________________________________________________ \n");
        sb2.append("|                        FLIGHT RESERVATION SYSTEM                        |\n");
        sb2.append("|            Please choose one of the options below to continue.          |\n");
        sb2.append("|_________________________________________________________________________|\n");
        sb2.append("|                             1. BOOKING.                                 |\n");
        sb2.append("|                             2. EXIT                                     |\n");
        sb2.append("|_________________________________________________________________________|\n");
        sb2.append(">>> Your selection: ");
        System.out.println(sb2);
    }

    void visitor() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" ______________________________________________________ \n");
        sb2.append("|              FLIGHT RESERVATION SYSTEM               |\n");
        sb2.append("|  Please choose one of the options below to continue. |\n");
        sb2.append("|______________________________________________________|\n");
        sb2.append("|                     1. Log In.                       |\n");
        sb2.append("|                     2. Sign Up.                      |\n");
        sb2.append("|                     3. Exit.                         |\n");
        sb2.append("|______________________________________________________|\n");
        sb2.append(">>> Your selection: ");
        System.out.println(sb2);
    }

}
