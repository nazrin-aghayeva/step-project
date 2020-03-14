package az.company.booking_project.Dao;


import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.Flight;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight> {
    private Database database = new Database();

    @Override
    public List<Flight> getAll() throws IOException, ClassNotFoundException {
        return database.getAllFlights();
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

        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }



}
