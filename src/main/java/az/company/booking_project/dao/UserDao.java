package az.company.booking_project.dao;


import az.company.booking_project.entities.Database;
import az.company.booking_project.entities.Flight;
import az.company.booking_project.entities.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao implements Dao<User> {
    public Database database=new Database();

    @Override
    public Optional<User> getById(int id) throws IOException, ClassNotFoundException {
        return database.getAllUsers()
                .stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    @Override
    public List<User> getAll() {
        return database.getAllUsers();
    }

    @Override
    public Optional<User> get(User user) {
        return database.getAllUsers().
                stream().filter(x->x.equals(user)).findAny();
    }

    @Override
    public boolean create(User user) {
        database.getUserlist().add(user);
        return database.writeToFileUsers();
    }

    @Override
    public boolean delete(int id) {
        List<User> collect = database.getAllUsers()
                .stream()
                .filter(user -> user.getId() == id)
                .collect(Collectors.toList());
        database.getUserlist().removeAll(collect);
        return database.writeToFileUsers();
    }



}
