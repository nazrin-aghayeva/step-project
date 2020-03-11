package project.booking.entity;

import java.util.HashSet;
import java.util.Objects;

public class User {

    static int counter = 1;

    public int id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;


    public User(String username, String password, String firstName, String lastName) {
        this.id = counter++;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Passenger getAsPassenger() {
        return new Passenger(firstName, lastName);
    }

}