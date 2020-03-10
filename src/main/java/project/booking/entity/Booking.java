package project.booking.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Objects;

public class Booking {



    private Integer bookingId;
    private final LocalDateTime date = LocalDateTime.now();
    private Flight flight;
    private User user;
    private Passenger passenger;

    public Booking(Flight flight, Passenger passenger, User user, int id) {
        this.bookingId = id;
        this.flight = flight;
        this.user = user;
        this.passenger = passenger;
    }

    public Booking(Flight flight, Passenger passenger, int id){
        this.bookingId = id;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Booking(int flightId, Flight flight, User user){
        this.bookingId = flightId;
        this.flight = flight;
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        return fmt.format(
                "%s %-3s %s %-20s %s %-25s %s %-15s %s %-10s %s %-15s %s %-5s",
                "|", bookingId,
                "|", user.getFullName(),
                "|", passenger.getFullName(),
                "|", flight.getDeparture().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", flight.getOrigin().toString(),
                "|", flight.getArrival().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", flight.getDestination()
        ).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flight, user);
    }
}
