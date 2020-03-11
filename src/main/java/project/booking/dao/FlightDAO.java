package project.booking.dao;

import project.booking.entity.Flight;

import java.io.*;
import java.util.*;

public class FlightDAO implements DAO <Flight>{

    private File file;
    private List<Flight> flights;
    private DAOBin<Flight> io;

    public FlightDAO() {
        this(new File("./db", "flights.txt"));
    }

    public FlightDAO(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.file = file;
        this.flights = new ArrayList<>();
        this.io = new DAOBin<>(file, flights);
    }

    @Override
    public List<Flight> findAll() {
        return flights;
    }

    @Override
    public Optional<Flight> findById(int id) {
        return flights.stream().filter(flight -> flight.id == id).findFirst();
    }


    @Override
    public boolean create(Flight flight) {
        if (flight == null || flights.contains(flight)) return false;
        flights.add(flight);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Optional<Flight> chosen = flights.stream().filter(flight -> flight.id == id).findFirst();
        if (chosen.isPresent()) {
            return flights.remove(chosen.get());
        }
        return false;
    }

    @Override
    public void load() {
        io.load();
    }

    @Override
    public void save() {
        io.save();
    }

}
