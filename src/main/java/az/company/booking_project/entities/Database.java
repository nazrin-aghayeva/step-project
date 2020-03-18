package az.company.booking_project.entities;

import az.company.booking_project.Exceptions.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Database implements Serializable {

    private List<User> userList=new ArrayList<>();
    private List<Flight> flightList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();


    public boolean writeToFileUsers(){
        try {
            File userFile=new File("users.txt");
            FileOutputStream fos=new FileOutputStream(userFile);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
            return true;
        }catch (IOException e) {
            throw new FileException("File is not found");
        }
    }

    public List<User> readFromFileUsers()  {
        try{
            File userFile = new File("users.txt");
            FileInputStream fis = new FileInputStream(userFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (List<User>) ois.readObject();
            ois.close();
            fis.close();}
        catch (IOException e){
            throw new FileException("File is not found");
        }
        catch (ClassNotFoundException ex){
            throw new FileException("Class not found");

        }
        return userList;
    }

    public List<Flight> readFromFileFlights()  {
        try{
        File fileFlights = new File("flights.txt");
        FileInputStream fis = new FileInputStream(fileFlights);
        ObjectInputStream ois = new ObjectInputStream(fis);
        flightList = (List<Flight>) ois.readObject();
        ois.close();
        fis.close();}
        catch (IOException| ClassNotFoundException e){
            throw new FileException("File is not found");

        }
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
            throw new FileException("File is not found");
        }
        return bookingList;
    }
    public  boolean writeToFileBooking(){

        try {
            File file = new File("bookings.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookingList);
            oos.close();
            fos.close();
            return true;

        }
            catch (IOException e) {
                throw new FileException("File is not found");
            }

//        }catch (Exception io){
//            io.printStackTrace();
//            System.out.println(io.getMessage());
//            throw new RuntimeException();
//        }
    }

    public List<User> getAllUsers() {
        return readFromFileUsers();
    }

    public List<Flight> getAllFlights() {
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

    public List<User> getUserlist() {
        return userList;
    }

}
