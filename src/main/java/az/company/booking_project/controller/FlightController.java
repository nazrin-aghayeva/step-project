package az.company.booking_project.controller;


import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.services.FlightService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlightController {

    private FlightService flightService = new FlightService();
    Scanner scanner = new Scanner(System.in);

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

    public void GettAllFlights() throws IOException, ClassNotFoundException {
        System.out.println("<<All possible flights>>");
        getAll();
    }
public void GetFlightsById() throws IOException, ClassNotFoundException {
        try {
            System.out.print("Please enter ID of flight: ");
            int id = scanner.nextInt();
            getById(id);
        }
        catch (InputMismatchException ex){
            System.out.println("enter valid data");
        }
}
}
