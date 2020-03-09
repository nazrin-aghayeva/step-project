package project.booking.dao;
import project.booking.entity.User;

import java.io.FileNotFoundException;
import java.util.List;

public interface DAO<A> {
    A get(int id);
    List<A> getAll();
    void create(A a);
    void delete(int id);
    void Write() throws FileNotFoundException;
    void Read();
}
