package az.company.booking_project.controller;


import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.services.FlightService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FlightController {

    private FlightService flightService = new FlightService();

    public void getAll() throws IOException, ClassNotFoundException {
        flightService.getAll().forEach(System.out::println);
    }

    public void getById(int id) throws IOException, ClassNotFoundException {
        try {
            System.out.println(flightService.getById(id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void search(Flight flight) throws IOException, ClassNotFoundException {
        try {
            Flight search = flightService.search(flight);
            System.out.println(search.toString());
        } catch (Exception e) {
            System.out.println("This Flight hasn't found");
        }

    }
//public List<String> filteredFlights(ArrivalCity to, LocalDateTime departure_time) throws IOException, ClassNotFoundException {
//    return flightService.filteredFlights(to, departure_time);
//}
}
