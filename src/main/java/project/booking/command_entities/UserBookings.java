package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;

public class UserBookings implements Executable {
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public UserBookings(Connector connector) {
        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {
        console.printLn(switcher.userBookings(connector.user.firstName, connector.user.lastName));
    }
}
