//package project.booking.dao;
//
//import project.booking.entity.Flight;
//import project.booking.entity.User;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//public class BookingDAO implements DAO<Flight> {
//    private Map<Flight, User> storage = new HashMap<>();
//
//    @Override
//    public Flight get(int id) {
//        return storage.get(id);
//    }
//
//    @Override
//    public Optional<Flight> getAll() {
//        return storage.values();
//    }
//
//    @Override
//    public void create(Flight flight) {
//
//    }
//    @Override
//    public void delete(int id) {
//        storage.remove(id);
//    }
//}
//
//}
