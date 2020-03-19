package az.company.booking_project.entities;

import java.util.*;

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
    PARIS("LBG"),
    MEXICO("ACA");

    private final String code;

    ArrivalCity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

private static final List<ArrivalCity> VALUES = new ArrayList<>(Arrays.asList(ArrivalCity.values()));

    public static ArrivalCity getRandomCity()  {
        Collections.shuffle(VALUES);
        return VALUES.remove(0);
    }

}
