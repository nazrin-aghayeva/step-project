package az.company.booking_project.entities;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String name;
    private String surname;

    public Passenger(String name, String surname) {
        this.name=name;
        this.surname=surname;
    }



    @Override
    public String toString() {
        return String.format("%s %s ", name, surname);
    }
}
