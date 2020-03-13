package az.company.booking_project.entities;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String nameSurname;

    public Passenger(String name) {
        this.nameSurname=name;
    }



    @Override
    public String toString() {
        return String.format("Passenger nameSurname %s", nameSurname);
    }
}
