package booking_project.controller;


import az.company.booking_project.entities.User;
import az.company.booking_project.services.UserService;

public class UserController {
    private UserService userService =new UserService();
    public void getUser(User user) {
        userService.getUser(user);
    }

    public void creatNewUser(User user) {
        userService.createNewUser(user);
    }
}
