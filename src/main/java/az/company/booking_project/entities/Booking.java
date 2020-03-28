package az.company.booking_project.entities;

import java.io.Serializable;
import java.util.List;

public class Booking implements Serializable {
    private int booking_id;
    private int flightID;
    private List<Passenger> passengers;
    static int count=0;

    public Booking( int flightID, List<Passenger> passengers) {
        this.booking_id = ++count;
        this.flightID = flightID;
        this.passengers = passengers;
    }

    public int getId() {
        return booking_id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return booking_id == booking.booking_id;
    }
    @Override
    public String toString() {
        return String.format("Booking ID:%-3d Flight ID:%-3d Passenger List:%-12s", booking_id, flightID, passengers);
    }
}
