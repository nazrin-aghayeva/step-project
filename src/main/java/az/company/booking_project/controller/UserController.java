package az.company.booking_project.controller;


import az.company.booking_project.entities.User;
import az.company.booking_project.services.Console;
import az.company.booking_project.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserController {
    private UserService userService =new UserService();
    public void getUser(User user) {
        userService.getUser(user);
    }
    Scanner scanner = new Scanner(System.in);


    public void SignUp() {
        System.out.println("Username:");
        String usernameRegist = scanner.next();
        System.out.println("Password:");
        String passwordRegist= scanner.next();
        if (!userService.createNewUser(usernameRegist, passwordRegist)) {
            System.out.println("Someone else has already taken this one.");
            return;
        }
        System.out.println("New account created successfully! ");
    }

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
