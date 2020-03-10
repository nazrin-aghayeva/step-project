package project.booking.entity;


import project.booking.enums.Airline;
import project.booking.enums.ArrivalCity;
import project.booking.enums.DepartureCity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightGenerator {
    private final Random rand = new Random();

    public List<Flight> generateFlights(int howMany) {
        List<Flight> flights = new ArrayList<>();
        String flightNo;
        Airline airline;
        int capacity;
        ArrivalCity origin;
        DepartureCity destination;
        LocalDateTime departure, arrival;

        for (int i = 0; i < howMany; i++) {
            airline = generateAirline();
            flightNo = generateFlightNo(airline);
            capacity = randomIntegerBetween(150, 200) / 10 * 10;
            origin = generateArrivalCity();
            do {
                destination = DepartureCity.KIEV;
            } while (origin.equals(destination));
            departure = generateDateTime(30);
            arrival = departure.plusHours(randomIntegerBetween(2, 8));

            flights.add(new Flight(flightNo, airline, capacity, origin, departure, destination, arrival));
        }

        return flights;
    }

    public int randomIntegerBetween(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range + 1 + min);
    }

    public LocalDateTime generateDateTime(int rangeFromNow) {
        long lo = LocalDate.now().toEpochDay();
        long hi = LocalDate.now().plusDays(rangeFromNow).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(lo, hi);

        LocalDateTime randomTime = LocalDateTime.of(
                LocalDate.ofEpochDay(randomDay),
                LocalTime.of(rand.nextInt(24), (rand.nextInt(60) / 30) * 30)
        );

        return (randomTime.isAfter(LocalDateTime.now())) ? randomTime : randomTime.plusDays(1);
    }

    private Airline generateAirline() {
        return Airline.values()[rand.nextInt(Airline.values().length)];
    }

    public String generateFlightNo(Airline airline) {
        return airline.getCode() + randomIntegerBetween(100, 950);
    }

    public ArrivalCity generateArrivalCity() {
        return ArrivalCity.getRandomCity();
    }
}
