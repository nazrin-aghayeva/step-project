package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;
import project.booking.enums.InputTypes;

public class CancelBooking implements Executable{
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public CancelBooking(Connector connector) {
        this.switcher = connector.getSwitcher();
        this.console = connector.getConsole();
        this.connector = connector;
    }

    @Override
    public void execute() {
        String bookingId = connector.getInput("Booking ID: ", InputTypes.BOOKING_NO);
        if(bookingId.isEmpty()) return;
        console.printLn(switcher.cancelBooking(bookingId));
    }
}
