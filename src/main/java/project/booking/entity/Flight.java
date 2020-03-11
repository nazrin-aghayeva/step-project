package project.booking.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;

public class Flight {
    static int counter=1;
    public Integer id;
    public String flightNo;
    public Airline airline;
    public ArrivalCity origin;
    public  DepartureCity destination;
    public LocalDateTime departure, arrival;
    public Integer emptySeats;
    public Integer seatcapacity=200;
    public List<Passenger> passengers = new ArrayList<>();
    public Integer passNumber = 0;


    public Flight( Integer emptySeats, String flightNo, Airline airline, ArrivalCity origin, LocalDateTime departure, DepartureCity destination, LocalDateTime arrival) {
        this.id = counter++;
        this.airline= airline;
        this.flightNo= flightNo;
        this.emptySeats= emptySeats;
        this.origin= origin;
        this.departure= departure;
        this.destination= destination;
        this.arrival= arrival;
    }

    public void addPassenger(Passenger passenger) {
        if(seatcapacity!=passengers.size()) {
            this.passengers.add(passenger);
            passNumber = passengers.size();
        }

    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        passNumber = passengers.size();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                Objects.equals(flightNo, flight.flightNo) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(origin, flight.origin) &&
                Objects.equals(arrival, flight.arrival) &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, departure, origin, arrival, destination);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        return fmt.format(
                "%s %-3s %s %-5s %s %-20s %s %-12s %s %-15s %s %-12s %s %-15s %s %-3s %s",
                "|", id,
                "|", flightNo,
                "|", airline,
                "|", origin,
                "|", departure.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", destination,
                "|", arrival.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", emptySeats,
                "|"
        ).toString();
    }
}