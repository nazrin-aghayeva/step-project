package az.company.booking_project.services;


import az.company.booking_project.dao.FlightDao;
import az.company.booking_project.entities.Flight;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FlightService {
    private FlightDao flightDao = new FlightDao();
    private List<Flight> currentTable;

    public List<Flight> findAllFlights() throws IOException, ClassNotFoundException {
        currentTable = flightDao.getAll();
        return currentTable;
    }
    public  List<Flight> getAll() throws IOException, ClassNotFoundException {
        return flightDao.getAll();
    }

    public Optional<Flight> getById(int id) throws IOException, ClassNotFoundException {
        return flightDao.getById(id);
    }

    public Flight search(Flight flight) throws IOException, ClassNotFoundException {
        return  flightDao.get(flight)
                .orElseThrow(()->new IllegalArgumentException("flight not found"));
    }

    public void create(Flight flight) throws IOException, ClassNotFoundException {
        flightDao.create(flight);
        refresh();
    }
    public void refresh() throws IOException, ClassNotFoundException {
        currentTable = findAllFlights();
    }

}
