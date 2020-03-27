package az.company.booking_project.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll() throws IOException, ClassNotFoundException;
    Optional<T> get(T t) throws IOException, ClassNotFoundException;
    Optional<T> getById(int id) throws IOException, ClassNotFoundException;
    boolean create(T t);
    boolean delete(int id) throws IOException, ClassNotFoundException;



}
