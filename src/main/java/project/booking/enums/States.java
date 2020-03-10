package project.booking.enums;

import java.util.*;

public enum States {
    USER(new HashMap<String, Commands>() {{
        put("1", Commands.TIMETABLE);
        put("2", Commands.SEARCH_BOOK);
        put("3", Commands.FLIGHT_DETAILS);
        put("4", Commands.USER_BOOKINGS);
        put("5", Commands.CANCEL_BOOKING);
        put("6", Commands.LOGOUT);
        put("7", Commands.EXIT);
        put("EXIT", Commands.EXIT);
    }}),

    VISITOR(new HashMap<String, Commands>() {{
        put("1", Commands.TIMETABLE);
        put("2", Commands.FLIGHT_DETAILS);
        put("3", Commands.PASSENGER_BOOKINGS);
        put("4", Commands.LOGIN);
        put("5", Commands.REGISTER);
        put("6", Commands.EXIT);
        put("EXIT", Commands.EXIT);
    }});

    private final Map<String, Commands> commands;

    States(HashMap<String, Commands> commands) {
        this.commands = commands;
    }

    public Map<String, Commands> getCommands() {
        return commands;
    }
}
