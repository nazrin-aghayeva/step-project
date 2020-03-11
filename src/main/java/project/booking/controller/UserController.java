package project.booking.controller;


import project.booking.entity.User;
import project.booking.service.UserServiceImpl;

import java.io.File;
import java.util.Optional;


public class UserController {

    private final UserServiceImpl service;

    public UserController() {
        this(new File("./db", "users.txt"));
    }

    public UserController(File file) {
        service = new UserServiceImpl(file);
    }


    public boolean create(User user) {
        return service.create(user);
    }

    public boolean isUsername(String line) {
        return service.isUsername(line);
    }

    public boolean isPassword(String line) {
        return service.isPassword(line);
    }

    public Optional<User> getUser(String username, String password) {
        return service.getUser(username, password);
    }

    public String getPassword(String username) {
        return service.getPassword(username);
    }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }
}
