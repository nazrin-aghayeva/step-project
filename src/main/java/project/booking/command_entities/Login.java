package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;
import project.booking.Validator;
import project.booking.entity.User;
import project.booking.enums.Commands;

import java.util.Optional;

public class Login implements Executable {
    public final Validator validator;
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public Login(Connector connector) {
        this.validator = connector.validator;
        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {
        String[] credentials = new String[2];
        boolean isExit = false;
        while (!isExit) {
            credentials = getCredentials();

            if (credentials[0].equalsIgnoreCase(Commands.EXIT.toString())
                    || credentials[1].equalsIgnoreCase(Commands.EXIT.toString())) return;

            String result = validator.isValidUser(credentials[0], credentials[1]);
            if (result.isEmpty()) isExit = true;
            else console.printLn(result);
        }

        Optional<User> result = switcher.login(credentials[0], credentials[1]);
        if (result.isPresent()) {
            connector.setUserActivated(true);
            connector.setUser(result.get());
        }
    }

    private String[] getCredentials() {
        String[] credentials = new String[2];
        console.print("Username: ");
        credentials[0] = console.readLn().trim();
        if (credentials[0].equalsIgnoreCase(Commands.EXIT.toString())) return credentials;
        console.print("Password: ");
        credentials[1] = console.readLn().trim();
        if (credentials[1].trim().equalsIgnoreCase(Commands.EXIT.toString())) return credentials;
        return credentials;
    }
}
