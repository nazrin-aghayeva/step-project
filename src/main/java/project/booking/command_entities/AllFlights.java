package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;

public class AllFlights implements Executable {

    public final Console console;
    public final Switcher switcher;

    public AllFlights(Connector connector){
        this.switcher = connector.getSwitcher();
        this.console = connector.getConsole();
    }

    @Override
    public void execute() {
        console.printLn(switcher.allFlights());
    }
}
