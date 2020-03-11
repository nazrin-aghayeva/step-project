package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;

public class Exit implements Executable {
    public final Console console;
    public final Switcher switcher;

    public Exit(Connector connector) {
        this.switcher = connector.getSwitcher();
        this.console = connector.getConsole();
    }

    @Override
    public void execute() {
        console.printLn(switcher.exit());
    }
}
