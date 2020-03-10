package project.booking.entity;

import project.booking.enums.ArrivalCity;
import project.booking.enums.DepartureCity;

public class Flight {
    public final DepartureCity departure=DepartureCity.KIEV;
    public final ArrivalCity arrival;

    public Flight(ArrivalCity arrival) {
        this.arrival = arrival;
    }
}
