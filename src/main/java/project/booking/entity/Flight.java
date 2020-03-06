package project.booking.entity;

import az.company.project.booking.enums.ArrivalCity;
import az.company.project.booking.enums.DepartureCity;

public class Flight {
    public final DepartureCity departure=DepartureCity.KIEV;
    public final ArrivalCity arrival;

    public Flight(ArrivalCity arrival) {
        this.arrival = arrival;
    }
}
