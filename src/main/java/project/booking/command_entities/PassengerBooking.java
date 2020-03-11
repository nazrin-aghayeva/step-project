package project.booking.command_entities;



import project.booking.Connector;
import project.booking.Console;
import project.booking.Pair;
import project.booking.Switcher;
import project.booking.enums.InputTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassengerBooking implements Executable {
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public PassengerBooking(Connector connector) {
        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {

        List<Pair> requirements = new ArrayList<>(Arrays.asList(
                new Pair("Name: ", InputTypes.NAME),
                new Pair("Surname: ", InputTypes.SURNAME)));

        List<String> inputs = new ArrayList<>();
        for (Pair p : requirements) {
            String input = connector.getInput(p.message, p.types);
            if (input.isEmpty()) return;
            inputs.add(input);
        }

        console.printLn(switcher.bookingsMadeFor(inputs.get(0), inputs.get(1)));
    }
}
