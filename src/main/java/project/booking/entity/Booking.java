package project.booking.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Objects;

public class Booking {
    public final Integer bookingId;
    public final LocalDateTime date = LocalDateTime.now();
    public  Flight flight;
    public  User user;
    public Passenger passenger;

    public Booking(Flight flight, Passenger passenger, User user, int bookingId) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.user = user;
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
                "|", flight.departure.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", flight.origin.toString(),
                "|", flight.arrival.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "|", flight.destination
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
