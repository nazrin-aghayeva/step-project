package project.booking.service;


import project.booking.entity.User;

import java.util.Optional;

public interface UserService {

    boolean create(User user);

    boolean isUsername(String line);


    boolean isPassword(String line);

    Optional<User> getUser(String username, String password);

    String getPassword(String username);

    void save();

    void load();
}