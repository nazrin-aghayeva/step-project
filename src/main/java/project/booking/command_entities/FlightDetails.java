package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;
import project.booking.enums.InputTypes;

public class FlightDetails implements Executable {
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public FlightDetails(Connector connector) {
        this.switcher = connector.getSwitcher();
        this.console = connector.getConsole();
        this.connector = connector;
    }
    @Override
    public void execute() {
        String flightId = connector.getInput("Flight ID: ", InputTypes.FLIGHT_NO);
        if (flightId.isEmpty()) return;
        console.printLn(switcher.flightDetails(flightId));
    }
}
