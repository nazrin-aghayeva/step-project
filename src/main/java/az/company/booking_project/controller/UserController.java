package az.company.booking_project.controller;


import az.company.booking_project.Validator;
import az.company.booking_project.entities.User;
import az.company.booking_project.services.UserService;

import java.util.Optional;
import java.util.Scanner;

import static az.company.booking_project.Validator.checkPassword;

public class UserController {
    private UserService userService =new UserService();


    public void getUser(User user) {
        userService.getUser(user);
    }
    Scanner scanner = new Scanner(System.in);


    public void SignUp() {
        System.out.println("Username:");
        String usernamereg = scanner.next();
        Optional<String> passwordreg = Optional.empty();
        while((!passwordreg.isPresent()) || !checkPassword(passwordreg.get())){
            System.out.println("Please, enter your password: (Password must consist of capital,small letters and numbers between [0:9] and symbols) ");
            passwordreg =Optional.of(scanner.next());
                  }
        if (!userService.createNewUser(usernamereg, passwordreg.get())) {
            System.out.println("Someone else has already taken this username.");
        }
        else{System.out.println("New account created successfully! ");
    }}

    public void LogIn(){

            System.out.println("Username:");
            String username = scanner.next();
            System.out.println("Password:");
            String password = scanner.next();
            getUser(new User(username, password));
            System.out.println("You have successfully logged in");

//        catch (InputMismatchException e){
//            System.out.println("Invalid input! Please enter menu item!");
//        }catch (Exception e) {
//            System.out.println("User doesn't exist, please sign up");
//            command1 = false;
//        }
    }
}
