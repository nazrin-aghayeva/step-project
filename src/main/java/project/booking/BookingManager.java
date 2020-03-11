package project.booking;


import project.booking.command_entities.Executable;
import project.booking.command_entities.Login;
import project.booking.command_entities.Register;
import project.booking.controller.BookingController;
import project.booking.controller.FlightController;
import project.booking.controller.UserController;
import project.booking.enums.Commands;
import project.booking.enums.States;

public class BookingManager {
    public final Console console;
    public final Menu menu;
    public final Database database;
    public final Validator validator;
    public States state = States.VISITOR;
    public Connector connector;

    public BookingManager() {
        this.console = new SystemConsole();
        this.menu = new Menu();
        FlightController flightController = new FlightController();
        BookingController bookingController = new BookingController();
        UserController userController = new UserController();
        this.database = new Database(userController, flightController, bookingController);
        Switcher switcher = new Switcher(flightController, bookingController, userController);
        this.validator = new Validator(flightController, bookingController, userController, console);
        this.connector = new Connector(this.validator, switcher, this.console);
    }

    public void run() {
        database.init();
        boolean isEnd = true;
        while (isEnd) {
            console.print(menu.display(state));
            String line = console.readLn();
            Commands command = validator.resolveCommand(line, state);
            Executable commandBasic;
            switch (command) {
                case LOGIN: {
                    commandBasic = new Login(connector);
                    commandBasic.execute();
                    if (connector.isUserActivated)state = States.USER;
                    break;
                }
                case REGISTER: {
                    commandBasic = new Register(connector);
                    commandBasic.execute();
                    break;
                }
                case TIMETABLE: {
                    commandBasic = new AllFlights(connector);
                    commandBasic.execute();
                    break;
                }
                case SEARCH_BOOK: {
                    commandBasic = new SearchAndBook(connector);
                    commandBasic.execute();
                    break;
                }
                case PASSENGER_BOOKINGS: {
                    commandBasic = new PassengerBooking(connector);
                    commandBasic.execute();
                    break;
                }
                case USER_BOOKINGS: {
                    commandBasic = new UserBookings(connector);
                    commandBasic.execute();
                    break;
                }
                case FLIGHT_DETAILS: {
                    commandBasic = new FlightDetails(connector);
                    commandBasic.execute();
                    break;
                }
                case CANCEL_BOOKING: {
                    commandBasic = new CancelBooking(connector);
                    commandBasic.execute();
                    break;
                }
                case LOGOUT: {
                    commandBasic = new Logout(connector);
                    commandBasic.execute();
                    if (!connector.UserActivated) state = States.VISITOR;
                    break;
                }
                case EXIT: {
                    commandBasic = new Exit(connector);
                    commandBasic.execute();
                    isEnd = false;
                    break;
                }
                case NO_COMMAND: {
                    console.printLn(Commands.NO_COMMAND.getDescription());
                    break;
                }
            }

        }
    }
}
