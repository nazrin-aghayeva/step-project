package project.booking.entity;

import java.io.Serializable;

public class Passenger  {
      public int counter=1;
     public int id;
     public String firstName;
     public String lastName;


    public Passenger(String firstName, String lastName){
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
