package project.booking.service;

import project.booking.dao.UserDAO;
import project.booking.entity.User;

import java.io.File;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAO();
    }

    public UserServiceImpl(File file) {
        userDAO = new UserDAO(file);
    }

    @Override
    public boolean create(User user) {
        return userDAO.create(user);
    }

    @Override
    public boolean isUsername(String line) {
        return userDAO.getAllUsername().contains(line);
    }


    @Override
    public boolean isPassword(String line) {
        return !userDAO.findAll().stream()
                .filter(user -> user.password.equals(line))
                .collect(Collectors.toList())
                .isEmpty();
    }

    @Override
    public Optional<User> getUser(String username, String password) {
        return userDAO.findAll().stream()
                .filter(user -> user.password.equals(password))
                .filter(user -> user.username.equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public String getPassword(String username) {
        Optional<User> first = userDAO.findAll().stream()
                .filter(user -> user.username.equals(username))
                .findFirst();

        if (first.isPresent()) return first.get().password;
        return "";
    }

    @Override
    public void load() {
        userDAO.load();
    }

    @Override
    public void save() {
        userDAO.save();
    }
}
