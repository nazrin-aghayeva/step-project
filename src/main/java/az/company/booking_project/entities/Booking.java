package az.company.booking_project.entities;

import java.io.Serializable;
import java.util.List;

public class Booking implements Serializable {
    private int booking_id;
    private int flightID;
    private int user_id;
    private List<Passenger> passengers;
    static int count=0;

    public Booking(int user_id, int flightID, List<Passenger> passengers) {
        this.user_id=user_id;
        this.booking_id = ++count;
        this.flightID = flightID;
        this.passengers = passengers;
    }

    public Booking(int flight_id, List<Passenger> passenger) {
        this.booking_id = ++count;
        this.flightID = flight_id;
        this.passengers = passenger;
    }

    public int getUser_id() {
        return user_id;
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
        return String.format("Booking ID:%-3d User ID:%-3d Flight ID:%-3d Passenger List:%-12s", booking_id, user_id, flightID, passengers);
    }
}
