package project.booking.command_entities;


import project.booking.Connector;
import project.booking.Console;
import project.booking.Switcher;

public class Logout implements Executable {
    public final Console console;
    public final Switcher switcher;
    public final Connector connector;

    public Logout(Connector connector) {
        this.switcher = connector.switcher;
        this.console = connector.console;
        this.connector = connector;
    }

    @Override
    public void execute() {
        switcher.logout(connector.user.username);
        connector.setUserActivated(false);
    }
}
