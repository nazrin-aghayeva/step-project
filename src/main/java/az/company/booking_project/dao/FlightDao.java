package az.company.booking_project.dao;


import az.company.booking_project.entities.Booking;
import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.Flight;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDao implements Dao<Flight> {
    private Database database = new Database();
    File fileFlights = new File("flights.txt");

    @Override
    public List<Flight> getAll() throws IOException, ClassNotFoundException {
        return database.getAllFlights();
    }

    public List<Flight> getAlls() throws IOException, ClassNotFoundException {
        return database.getFlightList();
    }

    @Override
    public Optional<Flight> get(Flight flight) throws IOException, ClassNotFoundException {
        return database.getAllFlights().stream()
                .filter(flight1 -> flight1.getTo().name().equals(flight.getTo().name()) && flight1.getDate().equals(flight.getDate()))
                .findAny();
    }


    @Override
    public Optional<Flight> getById(int id) throws IOException, ClassNotFoundException {
        return database.getAllFlights()
                .stream()
                .filter(flight -> flight.getId() == id)
                .findAny();
    }



    @Override
    public boolean create(Flight flight) {
        database.getFlightList().add(flight);
        return database.writeToFile1();
    }

    @Override
    public boolean delete(int id) throws IOException, ClassNotFoundException {
        List<Flight> collect = database.getAllFlights()
                .stream()
                .filter(flight -> flight.getId() == id)
                .collect(Collectors.toList());
        database.getFlightList().removeAll(collect);
        return database.writeToFile1();

    }



}
