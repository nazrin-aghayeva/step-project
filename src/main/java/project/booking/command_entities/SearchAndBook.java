package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Pair;
import project.booking.Switcher;
import project.booking.enums.InputTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchAndBook implements Executable {

    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public SearchAndBook(Connector connector) {

        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {

        List<Pair> requirements = new ArrayList<>(Arrays.asList(
                new Pair("Origin: ", InputTypes.CITY),
                new Pair("Destination: ", InputTypes.CITY),
                new Pair("Date (dd/mm/yyyy): ", InputTypes.DATE),
                new Pair("Number of people: ", InputTypes.INTEGER)));

        List<String> inputs = new ArrayList<>();
        for (Pair p : requirements) {
            String input = connector.getInput(p.message, p.types);
            if (input.isEmpty()) return;
            inputs.add(input);
        }

        String result = switcher.search(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3));

        if (result.isEmpty()) {
            console.printLn("No flights were found for that criterias.");
            return;
        }

        console.printLn(result);
        String flightNo = connector.getInput("Enter flight ID to book or 'exit': ", InputTypes.FLIGHT_NO);

        if (flightNo.isEmpty()) return;


        int numberOfPassenger = Integer.parseInt(inputs.get(3));
        for (int i = 0; i < numberOfPassenger; i++) {
            String[] user = getPassenger(i);
            if (user[0].isEmpty() || user[1].isEmpty()) return;
            console.printLn(switcher.book(flightNo, user[0], user[1], connector.user));
        }

    }

    private String[] getPassenger(int num) {
        String[] user = new String[2];
        user[0] = connector.getInput("Name: ", InputTypes.NAME);
        user[1] = connector.getInput("Surname: ", InputTypes.SURNAME);

        return user;
    }
}
