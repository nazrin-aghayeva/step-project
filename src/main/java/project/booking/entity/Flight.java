package project.booking.entity;

import java.util.Objects;

public class Flight {
    public final City src;
    public final City dest;
    public final Integer id;
    public final int emptySeats;


    public Flight(City src, City dest, Integer id, int emptySeats) {
        this.src = src;
        this.dest = dest;
        this.id = id;
        this.emptySeats = emptySeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(src, flight.src) &&
                Objects.equals(dest, flight.dest) &&
                Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest, id, emptySeats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "src=" + src +
                ", dest=" + dest +
                ", id=" + id +
                ", emptySeats=" + emptySeats +
                '}';
    }
}
