package project.booking.service;


import project.booking.dao.FlightDAO;
import project.booking.entity.ArrivalCity;
import project.booking.entity.DepartureCity;
import project.booking.entity.Flight;
import project.booking.entity.Passenger;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightDAO flightDAO;
    private List<Flight> currentTable;

    public FlightServiceImpl() {
        flightDAO = new FlightDAO();
    }

    public FlightServiceImpl(File file) {
        flightDAO = new FlightDAO(file);
    }

    public List<Flight> findAllFlights() {
        currentTable = flightDAO.findAll();
        return currentTable;
    }

    @Override
    public List<Passenger> findPassengersOfFlight(int flightId) {
        Optional<Flight> found = findFlightByFlightId(flightId);
        if(found.isPresent()){
            return found.get().passengers;
        }
        return new ArrayList<>();
    }



    @Override
    public List<Flight> findFlightsMatchedByCriteria(ArrivalCity origin, DepartureCity destination, LocalDate departure, int passengers) {

        currentTable = flightDAO.findAll()
                .stream()
                .filter(
                        f -> origin.equals(f.origin) &&
                                destination.equals(f.destination) &&
                                (f.departure.toLocalDate().equals(departure)) &&
                                f.emptySeats >= passengers
                )
                .collect(Collectors.toList());

        return currentTable;
    }

    @Override
    public void create(Flight flight) {
        flightDAO.create(flight);
    }

    @Override
    public Optional<Flight> findFlightByFlightId(int flightId) {
        return currentTable.stream().filter(flight -> flight.id == flightId).findFirst();
    }

    @Override
    public void remove(int flightId) {
        flightDAO.remove(flightId);
    }

    @Override
    public void load() {
        flightDAO.load();
        findAllFlights();
    }

    @Override
    public void save() {
        flightDAO.save();
    }
}
