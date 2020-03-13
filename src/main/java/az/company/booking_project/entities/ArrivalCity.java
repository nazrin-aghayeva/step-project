package az.company.booking_project.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum ArrivalCity {
    BAKU("GYD"),
    ISTANBUL("IST"),
    NEW_YORK("JFK"),
    ROME("REO"),
    BARCELONA("BCN"),
    MOSCOW("SVO"),
    LOS_ANGELES("LAX"),
    BOSTON("BOS"),
    TORONTO("YYZ"),
    WASHINGTON("IAD"),
    ZURICH("ZRH"),
    BERLIN("SXF"),
    FRANKFURT("FRA"),
    TEHRAN("THR"),
    DUBAI("DXB"),
    LONDON("LHR"),
    AMSTERDAM("NL"),
    MINSK("MSQ"),
    PARIS("LBG");

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
    public static ArrivalCity get(String city){
        List<ArrivalCity> airports = Arrays.stream(values())
                .filter(airport -> city.equalsIgnoreCase(airport.toString()))
                .collect(Collectors.toList());
        return airports.get(0);
    }

}
