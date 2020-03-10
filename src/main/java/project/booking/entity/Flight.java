package project.booking.entity;

import project.booking.enums.Airline;
import project.booking.enums.ArrivalCity;
import project.booking.enums.DepartureCity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    public final Integer id;
    public final String flightNo;
    public final Airline airline;
    public final int capacity;
    public final ArrivalCity origin;
    public final DepartureCity destination;
    public final LocalDateTime departure, arrival;
    public final int emptySeats;


    public Flight(Integer id, int emptySeats, String flightNo, Airline airline, int capacity, ArrivalCity origin, LocalDateTime departure, DepartureCity destination, LocalDateTime arrival) {
        this.id = id;
        this.emptySeats = emptySeats;
        this.airline= airline;
        this.flightNo= flightNo;
        this.capacity= capacity;
        this.origin= origin;
        this.departure= departure;
        this.destination= destination;
        this.arrival= arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return
                Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, emptySeats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                ", id=" + id +
                ", emptySeats=" + emptySeats +
                '}';
    }
}