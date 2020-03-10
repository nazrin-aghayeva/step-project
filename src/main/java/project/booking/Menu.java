package project.booking;

import project.booking.enums.States;

public class Menu {

    public String display(States state) {
        switch (state) {
            case VISITOR:
                return this.visitorMenu();
            case USER:
                return this.userMenu();
        }
        return "";
    }

    private String visitorMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("===========================================================================\n");
        sb.append("|                        FLIGHT RESERVATION SYSTEM                        |\n");
        sb.append("|            Please choose one of the options below to continue.          |\n");
        sb.append("|                      You are connected as a Visitor                     |\n");
        sb.append("===========================================================================\n");
        sb.append("|                         1. View Timetable                               |\n");
        sb.append("|                         2. Timetable Within Range                       |\n");
        sb.append("|                         3. View Flight Details                          |\n");
        sb.append("|                         4. Search Made Bookings                         |\n");
        sb.append("|                         5. Sign In                                      |\n");
        sb.append("|                         6. Register                                     |\n");
        sb.append("|                         7. Exit                                         |\n");
        sb.append("===========================================================================\n");
        sb.append(">>> Your selection: ");
        return sb.toString();
    }

    private String userMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("===========================================================================\n");
        sb.append("|                        FLIGHT RESERVATION SYSTEM                        |\n");
        sb.append("|            Please choose one of the options below to continue.          |\n");
        sb.append("===========================================================================\n");
        sb.append("|                         1. View Timetable                               |\n");
        sb.append("|                         2. Timetable Within Range                       |\n");
        sb.append("|                         3. Search                                       |\n");
        sb.append("|                         4. View Flight Details                          |\n");
        sb.append("|                         5. My Bookings                                  |\n");
        sb.append("|                         6. Cancel a Booking                             |\n");
        sb.append("|                         7. End Session                                  |\n");
        sb.append("|                         8. Exit                                         |\n");
        sb.append("===========================================================================\n");
        sb.append(">>> Your selection: ");
        return sb.toString();
    }
}
