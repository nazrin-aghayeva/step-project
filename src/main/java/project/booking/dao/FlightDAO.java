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
        File userFile= new File("users.txt");
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

        }

        @Override
        public void delete(int id) {

        }

        @Override
        public void Write() throws FileNotFoundException {

        }

        @Override
        public void Read() {

        }

    }

        @Override
        public void create(Flight flight) {
            flights.put(flight.id, flight);
        }

        @Override
        public void delete(int id) {
            users.remove(id);
            Write();
        }
        @Override
        public void Write(){
            try( FileOutputStream fos= new FileOutputStream(userFile) ) {
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(users);
            }catch (IOException ex){
                System.out.println("No file found");
            }
        }
        @Override
        public void Read() {
            try( FileInputStream fis= new FileInputStream(userFile)){
                ObjectInputStream ois= new ObjectInputStream(fis);
                users= (Map<Integer, User>) ois.readObject();
            }
            catch (IOException | ClassNotFoundException ex){
                System.out.println("File from user is not found");
            }
        }


    }

}

