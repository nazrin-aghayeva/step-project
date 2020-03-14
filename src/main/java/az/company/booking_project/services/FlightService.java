package az.company.booking_project.services;


import az.company.booking_project.Dao.FlightDao;
import az.company.booking_project.entities.ArrivalCity;
import az.company.booking_project.entities.Flight;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDao flightDao = new FlightDao();

    public  List<Flight> getAll() throws IOException, ClassNotFoundException {
        return flightDao.getAll();
    }

//    public List<String> filteredFlights(ArrivalCity to, LocalDateTime departure_time) throws IOException, ClassNotFoundException {
//        return flightDao.getAll().stream().filter(
//                f -> to.equals(f.getTo()) &&
//                       departure_time.equals(f.getDate())
//        )
//                .map(Flight::toString).collect(Collectors.toList());
//
//    }

    public Flight getById(int id) throws IOException, ClassNotFoundException {
        return flightDao.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight cannot found!"));
    }

    public Flight search(Flight flight) throws IOException, ClassNotFoundException {
        return  flightDao.get(flight)
                .orElseThrow(()->new IllegalArgumentException("flight not found"));
    }
}
