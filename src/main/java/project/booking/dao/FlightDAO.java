package project.booking.dao;


import project.booking.entity.Flight;
import project.booking.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightDAO {

    public class UserDAO implements DAO<Flight> {
        Map<Integer, Flight> flights= new HashMap<>();
        File flightsFile= new File("flights.txt");
        @Override
        public Flight get(int id) {
            return flights.get(id);
        }

        @Override
        public List<Flight> getAll() {
            return new ArrayList<>(flights.values());
        }

        @Override
        public void create(Flight flight) {
            flights.put(flight.id, flight);
        }

        @Override
        public void delete(int id){
            flights.remove(id);
            Write();
        }

        @Override
        public void Write() {
            try(FileOutputStream fos= new FileOutputStream(flightsFile)){
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(flights);
            }
            catch (IOException ex){
                System.out.println("Something went wrong, file is not found");;
            }
        }

        @Override
        public void Read() {
           try(FileInputStream fis= new FileInputStream(flightsFile)){
               ObjectInputStream ois= new ObjectInputStream(fis);
               flights= (Map<Integer, Flight>) ois.readObject();
           }
           catch (IOException | ClassNotFoundException ex){
               System.out.println("Something went wrong, file from user is not found");
           }
        }

    }
}
