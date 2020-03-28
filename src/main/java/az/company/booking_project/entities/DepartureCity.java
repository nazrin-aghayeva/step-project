package az.company.booking_project.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DepartureCity {
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

    DepartureCity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private static final List<DepartureCity> VALUES = new ArrayList<>(Arrays.asList(DepartureCity.values()));

    public static DepartureCity getRandomCity()  {
        Collections.shuffle(VALUES);
        return VALUES.remove(0);
    }


}
