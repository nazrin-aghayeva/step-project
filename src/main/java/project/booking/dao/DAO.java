package project.booking.dao;
import java.util.List;
import java.util.Optional;

public interface DAO<A> {
    A get(int id);
    Optional<A> getAll();
    void create(A a);
    void delete(int id);

}
