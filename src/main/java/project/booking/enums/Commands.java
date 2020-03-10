package project.booking.enums;


public enum Commands {
    TIMETABLE("Timetable of All Flights"),
    SEARCH_BOOK("Search"),
    FLIGHT_DETAILS("Flight Details"),
    LOGIN("Log in"),
    REGISTER("Register"),
    USER_BOOKINGS("My Bookings"),
    PASSENGER_BOOKINGS("Search made bookings"),
    CANCEL_BOOKING("Cancel Booking"),
    LOGOUT("End Session"),
    EXIT("Exit"),
    NO_COMMAND("No command available");

    private final String description;
    Commands(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
