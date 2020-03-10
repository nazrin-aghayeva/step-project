package project.booking;


import project.booking.controller.BookingController;
import project.booking.controller.FlightController;
import project.booking.controller.UserController;
import project.booking.entity.Booking;
import project.booking.entity.Flight;
import project.booking.enums.Commands;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Validator {

    private final FlightController flightController;
    private final BookingController bookingController;
    private final UserController userController;
    private final Console console;

    public Validator(FlightController flightController, BookingController bookingController, UserController userController, Console console) {
        this.flightController = flightController;
        this.bookingController = bookingController;
        this.userController = userController;
        this.console = console;
    }

    public Commands resolveCommand(String line, States state) {

        Map<String, Commands> commands = state.getCommands();
        List<Commands> required = commands.keySet().stream()
                .filter(k -> line.equalsIgnoreCase(k))
                .map(k -> commands.get(k))
                .collect(Collectors.toList());

        if (required.isEmpty()) return Commands.NO_COMMAND;

        return required.get(0);
    }

    public boolean check(String line, InputTypes request) {
        switch (request) {
            case FLIGHT_NO:
                return isFlightNo(line);
            case BOOKING_NO:
                return isBookingNo(line);
            case DATE:
                return isDate(line);
            case CITY:
                return isValidCity(line);
            case NAME:
            case SURNAME:
                return isValidNaming(line);
            case EMAIL:
                return isEmail(line);
            case PASSWORD:
                return isPassword(line);
            case USERNAME:
                return isUsername(line);
            case INTEGER:
                return isInteger(line);
            case EXIT:
                return line.equalsIgnoreCase(InputTypes.EXIT.toString());
        }
        return false;
    }

    public String isValidUser(String username, String password){
        if(!userController.isUsername(username)) return "No such user was found.";
        if(!userController.getPassword(username).equals(password)) return "Wrong Password";
        return "";
    }

    private boolean isUsername(String line) {
        if (userController.isUsername(line)) {
            console.printLn("This username has been taken");
            return false;
        }

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isDigit(ch)) ;
            else if (Character.isLetter(ch)) ;
            else {
                console.printLn("You are only allowed to use numbers and letters");
                return false;
            }
        }
        return true;
    }

    private boolean isEmail(String line) {
        if (userController.isEmail(line)) {
            console.printLn("This email has been registered before.");
            return false;
        } else if (!line.contains("@")) {
            console.printLn("Invalid email address");
            return false;
        } else if(line.substring(line.indexOf("@")).length() < 4){
            console.printLn("Invalid email address");
            return false;
        }

        String symbols = "_-.";
        String[] parts = line.split("@");
        String prefix = parts[0];
        String domain = parts[1];

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (Character.isLetter(ch)) continue;
            else if (Character.isDigit(ch)) continue;
            else if (symbols.contains(ch + "")) continue;
            else {
                console.printLn("Invalid email address.");
                return false;
            }
        }

        if (!domain.contains(".")) {
            console.printLn("Invalid email address");
            return false;
        }
        for (int i = 0; i < domain.length(); i++) {
            char ch = domain.charAt(i);
            if (Character.isLetter(ch)) continue;
            else if (Character.isDigit(ch)) continue;
            else if (ch == '-' || ch == '.') continue;
            else {
                console.printLn("Invalid email address.");
                return false;
            }
        }

        return true;
    }

    private boolean isPassword(String line) {
        if (line.length() < 8) {
            console.printLn("Password must be longer than 8 characters.");
            return false;
        }
        boolean isUppercase = false;
        boolean isLowercase = false;
        boolean isSymbol = false;
        boolean isInteger = false;
        boolean isWhiteSpace = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isUpperCase(ch)) isUppercase = true;
            else if (Character.isLowerCase(ch)) isLowercase = true;
            else if (Character.isWhitespace(ch)) isWhiteSpace = true;
            else if (Character.isDigit(ch)) isInteger = true;
            else if (!Character.isLetter(ch)) isSymbol = true;
        }

        if (isInteger && isUppercase && isLowercase && isSymbol && !isWhiteSpace) return true;
        console.printLn("Not a valid password. Please, use upper, lower cases, symbols, integers, and WITHOUT whitespaces.");
        return false;
    }

    private boolean isValidCity(String line) {
        if (!Airport.isValid(line)) console.printLn("Invalid City.");
        return Airport.isValid(line);
    }

    private boolean isFlightNo(String line) {
        if (!isInteger(line)) return false;

        Integer num = Integer.parseInt(line);
        Optional<Flight> flightByFlightId = flightController.findFlightByFlightId(num);
        if (flightByFlightId.isPresent()) {
            return true;
        } else console.printLn("Invalid Flight Number");
        return false;
    }

    private boolean isBookingNo(String line) {
        if (!isInteger(line)) return false;

        Integer num = Integer.parseInt(line);
        Optional<Booking> bookingById = bookingController.findBookingById(num);
        if (bookingById.isPresent()) {
            return true;
        } else console.printLn("Invalid Booking ID");
        return false;
    }

    private boolean isDate(String line) {

        try {
            LocalDate.parse(line, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeException ex) {
            console.printLn("Invalid Date or Pattern.");
            return false;
        }

        return true;
    }

    private boolean isValidNaming(String line) {
        if (line.isEmpty()) return false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch < 'a' && ch > 'Z' || ch > 'z') return false;
            if (ch < 'A' && ch > 'Z') return false;
        }
        return true;
    }

    private boolean isInteger(String line) {
        try {
            Integer.parseInt(line);
        } catch (Exception ex) {
            console.printLn("Invalid input. Not an integer.");
            return false;
        }

        return true;
    }
}
