package project.booking.command_entities;


import project.booking.*;
import project.booking.enums.InputTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register implements Executable {
    public final Validator validator;
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public Register(Connector connector) {
        this.validator = connector.validator;
        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {

        List<Pair> requirements = new ArrayList<>(Arrays.asList(
                new Pair("Name : ", InputTypes.NAME),
                new Pair("Surname : ", InputTypes.SURNAME),
                new Pair("Password : ", InputTypes.PASSWORD),
                new Pair("Username : ", InputTypes.USERNAME)));

        List<String> inputs = new ArrayList<>();
        for (Pair p : requirements) {
            String input = connector.getInput(p.message, p.types);
            if (input.isEmpty()) return;
            inputs.add(input);
        }

        console.printLn(switcher.register(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3)));
    }
}
