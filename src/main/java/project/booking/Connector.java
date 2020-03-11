package project.booking;

import project.booking.entity.User;
import project.booking.enums.InputTypes;


public class Connector {
    public final Validator validator;
    public final Switcher switcher;
    public final Console console;
    public User user;
    public boolean isUserActivated;

    public Connector(Validator validator, Switcher switcher, Console console) {
        this.validator = validator;
        this.switcher = switcher;
        this.console = console;
    }


    public String getInput(String message, InputTypes dataType) {
        boolean isValid = false;
        String input = "";
        while (!isValid) {
            console.print(message);
            input = console.readLn();
            if (validator.check(input, InputTypes.EXIT)) {
                return "";
            } else if (validator.check(input.trim(), dataType)) {
                isValid = true;
            }

        }
        return input.trim();
    }
}
