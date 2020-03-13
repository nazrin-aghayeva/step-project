package az.company.booking_project.entities;

import java.io.Serializable;
import java.util.List;

public class Booking implements Serializable {
    private int booking_id;
    private int flightID;
    private List<Passenger> passengers;
    static int count=0;

    public Booking(int flightID, List<Passenger> passengers) {
        this.booking_id = ++count;
        this.flightID = flightID;
        this.passengers = passengers;
    }

    public int getId() {

        return booking_id;
    }

    @Override
    public String toString() {
        return String.format("Booking ID:%-3d Flight ID:%-3d PassengerList:%-12s \n", booking_id, flightID, passengers);
    }
}
