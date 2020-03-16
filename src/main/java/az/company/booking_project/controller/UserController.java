package az.company.booking_project.controller;


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

    public void deleteUser(int user_id){

            userService.deleteUser(user_id);
            System.out.println("Successfully logged out");

    }
}
