package booking_project.Dao;


import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    private Database database=new Database();
    @Override
    public Optional<User> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(User user) {
        return database.getAllUsers().stream().filter(x->x.equals(user)).findAny();

    }

    @Override
    public boolean create(User user) {
        database.getUserlist().add(user);
        return database.writeToFileUsers();
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
