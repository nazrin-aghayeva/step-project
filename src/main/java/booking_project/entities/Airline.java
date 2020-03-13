package booking_project.entities;

import java.util.Random;

public enum Airline {
    AMERICAN_AIRLINES("AA"),
    AIR_FRANCE("AF"),
    AEROFLOT("SU"),
    BRITISH_AIRWAYS("BA"),
    TURKISH_AIRLINES("TK"),
    LUFTHANSA("LH"),
    AZAL("J2");


    private final String code;

    Airline(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static String getRandomCode() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)].code;
    }
    public static Airline getRandomAirline() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }

}

