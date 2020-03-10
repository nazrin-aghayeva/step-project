package project.booking.entity;

import java.io.Serializable;
import java.util.HashSet;

public class User  {

    static int counter = 1;

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private HashSet<Booking> bookings;

    public User(int id, String username) {
        this.id = counter++;
        this.username = username;
    }

    public User(String username, String password, String firstName, String lastName, String email) {
        this.id = counter++;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Passenger getAsPassenger(){
        return new Passenger(firstName, lastName);
    }
}
