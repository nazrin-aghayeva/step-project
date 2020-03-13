package az.company.booking_project.controller;


import az.company.booking_project.entities.Flight;
import az.company.booking_project.services.FlightService;

import java.io.IOException;

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
            System.out.println(search);
        } catch (Exception e) {
            System.out.println("This Flight hasn't fount");
        }

    }
}
