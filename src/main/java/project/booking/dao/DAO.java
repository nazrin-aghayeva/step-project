package project.booking.dao;
import project.booking.entity.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface DAO<A> {
    List<A> findAll();
    Optional<A> findById(int id);
    boolean create(A t);
    boolean remove(int id);
    void load();
    void save();
}
