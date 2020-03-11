package project.booking;


import project.booking.controller.BookingController;
import project.booking.controller.FlightController;
import project.booking.controller.UserController;
import project.booking.entity.Flight;
import project.booking.entity.FlightGenerator;

import java.io.File;
import java.util.List;

public class Database {

    public final UserController userController;
    public final FlightController flightController;
    public final BookingController bookingController;
    public final FlightGenerator flightGenerator;

    public Database(UserController userController,
                    FlightController flightController,
                    BookingController bookingController) {
        this.userController = userController;
        this.flightController = flightController;
        this.bookingController = bookingController;
        this.flightGenerator = new FlightGenerator();
    }

    public void init() {
        File file = new File("./db", "flights.txt");
        if (file.length()!=0) {
            flightController.load();
        } else {
            List<Flight> flights = flightGenerator.generateFlights(50);
            for (Flight f : flights) {
                flightController.create(f);
            }
            flightController.save();
        }
        if (new File("./db","users.txt").exists()) {
            userController.load();
        }

        if (new File("./db","bookings.txt").exists()) {
            bookingController.load();
        }
    }
}
