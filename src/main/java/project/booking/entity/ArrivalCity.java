package project.booking.entity;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum ArrivalCity {
    LONDON("LHR"),
    BAKU("GYD"),
    MOSCOW("SVO"),
    ISTANBUL("IST"),
    FRANKFURT("FRA"),
    NEW_YORK("JFK"),
    ROME("REO"),
    BARCELONA("BCN"),
    PARIS("LBG"),
    BERLIN("SXF"),
    TEHRAN("THR"),
    DUBAI("DXB"),
    AMSTERDAM("NL"),
    MINSK("MSQ");

    private final String code;

    ArrivalCity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ArrivalCity getRandomCity() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }

    public static boolean isValid(String city){
        List<ArrivalCity> airports = Arrays.stream(values())
                .filter(airport -> city.equalsIgnoreCase(airport.toString()))
                .collect(Collectors.toList());

        if(airports.isEmpty()) return false;
        return true;
    }

    public static ArrivalCity get(String city){
        List<ArrivalCity> airports = Arrays.stream(values())
                .filter(airport -> city.equalsIgnoreCase(airport.toString()))
                .collect(Collectors.toList());
        return airports.get(0);
    }
}
