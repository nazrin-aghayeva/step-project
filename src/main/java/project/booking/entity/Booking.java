package project.booking.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Objects;

public class Booking {
    public final Integer bookingId;
    private final LocalDateTime date = LocalDateTime.now();
    public final Flight flight;
    public  User user;
//    public final Passenger passenger;

    public Booking(Flight flight,  int id) {
        this.bookingId = id;
        this.flight = flight;
    }

    public Booking(int flightId, Flight flight) {
        this.bookingId = flightId;
        this.flight = flight;
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
