package az.company.booking_project.controller;

import az.company.booking_project.entities.User;
import az.company.booking_project.services.UserService;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import static az.company.booking_project.Validator.checkPassword;

public class UserController {
    private UserService userService =new UserService();
    private boolean isUserActivated;

    public boolean isUserActivated() {
        return isUserActivated;
    }
    public void setUserActivated(boolean userActivated) {
        isUserActivated = userActivated;
    }

    public void getUser(User user) {
        userService.getUser(user);
    }

    Scanner scanner = new Scanner(System.in);


    public void SignUp() {
        try{
        System.out.println("Username:");
        String usernamereg = scanner.next();
        Optional<String> passwordreg = Optional.empty();
        while((!passwordreg.isPresent()) || !checkPassword(passwordreg.get())){
            System.out.println("Enter password: (Password must consist of capital, small letters and any numbers between [0:9] and symbols) ");
            passwordreg =Optional.of(scanner.next());
                  }
        if (!userService.createNewUser(usernamereg, passwordreg.get())) {
            System.out.println("Someone else has already taken this username, please enter another one.");
        }
        else {
            System.out.println("New account created successfully! ");
        }

    }
        catch (InputMismatchException ex){
            System.out.println("enter valid data...");
        }
    }

    public void LogIn(){
        try {
            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();
            getUser(new User(username, password));
            System.out.println("You have successfully logged in");
        }
        catch (InputMismatchException ex){
            System.out.println("Enter valid data");
        }

    }
    public void LogOut(){
        setUserActivated(false);
    }
}
