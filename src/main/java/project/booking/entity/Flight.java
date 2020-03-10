package project.booking.entity;

import project.booking.enums.Airline;
import project.booking.enums.ArrivalCity;
import project.booking.enums.DepartureCity;

import  java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;

public class Flight {


    static int counter = 1;

    private Integer flightId;
    private String flightNo;
    private final Integer capacity;
    private LocalDateTime departure;
    private Airline airline;
    private ArrivalCity origin;
    private LocalDateTime arrival;
    private DepartureCity destination;
    private List<Passenger> passengers = new ArrayList<>();
    private Integer passNumber = 0;

    public Flight(String flightNo, int capacity) {
        this.flightId = counter++;
        this.flightNo = flightNo;
        this.capacity = capacity;
    }

    public Flight(
                  String flightNo,
                  int capacity,
                  LocalDateTime departure,
                  ArrivalCity origin,
                  LocalDateTime arrival,
                  DepartureCity destination) {

        this.flightId = counter++;
        this.flightNo = flightNo;
        this.capacity = capacity;
        this.departure = departure;
        this.origin = origin;
        this.arrival = arrival;
        this.destination = destination;
    }

    public Flight(String flightNo,
                  Airline airline,
                  int capacity,
                  ArrivalCity origin,
                  LocalDateTime departure,
                  DepartureCity destination,
                  LocalDateTime arrival) {
        this.flightId = counter++;
        this.flightNo = flightNo;
        this.airline = airline;
        this.capacity = capacity;
        this.origin = origin;
        this.departure = departure;
        this.destination = destination;
        this.arrival = arrival;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public ArrivalCity getOrigin() {
        return origin;
    }

    public void setOrigin(ArrivalCity origin) {
        this.origin = origin;
    }

    public DepartureCity getDestination() {
        return destination;
    }

    public void setDestination(DepartureCity destination) {
        this.destination = destination;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        if(!isFull()) {
            this.passengers.add(passenger);
            passNumber = passengers.size();
        }

    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        passNumber = passengers.size();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public int availableSeats() {
        return capacity - passNumber;
    }

    public boolean isFull(){
        return capacity == passengers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId &&
                Objects.equals(flightNo, flight.flightNo) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(origin, flight.origin) &&
                Objects.equals(arrival, flight.arrival) &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNo, departure, origin, arrival, destination);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        return fmt.format(
                "%s %-3s %s %-5s %s %-20s %s %-12s %s %-15s %s %-12s %s %-15s %s %-3s %s",
                "|", flightId,
                "|", flightNo,
                "|", airline,
                "|", origin,
                "|", departure.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", destination,
                "|", arrival.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", capacity-passNumber,
                "|"
        ).toString();
    }
}
