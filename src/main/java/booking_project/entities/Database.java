package booking_project.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Database implements Serializable {



    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    private List<Flight> flightList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<User> userlist=new ArrayList<>();

    public List<User> getUserlist() {
        return userlist;
    }



    public List<Flight> readFromFileFlights() throws IOException, ClassNotFoundException {
        File file = new File("flights.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        flightList = (List<Flight>) ois.readObject();
        ois.close();
        fis.close();
        return flightList;
    }
    public List<Booking> readFromFileMyBookings(){
        try{
            File file = new File("bookings.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookingList= (List<Booking>) ois.readObject ();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
        return bookingList;
    }
    public  boolean writeToFileBooking(){

        try {
            File file=new File("bookings.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(bookingList);
            oos.close();
            fos.close();
            return true;
        }catch (Exception io){
            io.printStackTrace();
            System.out.println(io.getMessage());
            throw new RuntimeException();
        }
    }

    public List<Flight> getAllFlights() throws IOException, ClassNotFoundException {
        return readFromFileFlights();

    }

    public List<Booking> getAllBookings() {
        return readFromFileMyBookings();

    }



    public List<Booking> getBookingList() {
        return bookingList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }


    public List<User> getAllUsers() {
        return readFromFileUsers();
    }

    private List<User> readFromFileUsers() {
        try {
            File file =new File("users.txt");
            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fis);
            userlist= (List<User>) ois.readObject();
        }catch (Exception e){
            throw new RuntimeException();
        }
        return userlist;
    }
    public boolean writeToFileUsers(){
        try {
            File file=new File("users.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(userlist);
            oos.close();
            fos.close();
            return true;
        }catch (Exception io){
            io.printStackTrace();
            System.out.println(io.getMessage());
            throw new IllegalArgumentException("something went wrong");
        }
    }
}
