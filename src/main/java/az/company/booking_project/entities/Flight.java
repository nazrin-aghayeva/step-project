package az.company.booking_project.entities;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Flight implements Serializable {
    private int id;
    private Airline airline;
    private String flightNo;
    private DepartureCity from;
    private ArrivalCity to;
    private LocalTime arrival_time;
    private int empty_seats;
    private LocalDate arrival_date;
    private static int count = 0;
    static List<Flight> flights = new ArrayList<>();

    public Flight(int id,Airline airline,String flightNo, DepartureCity from, ArrivalCity to, LocalTime arrival_time, int empty_seats, LocalDate arrival_date) {
        this.id = id;
        this.airline=airline;
        this.flightNo=flightNo;
        this.from = from;
        this.to = to;
        this.arrival_time = arrival_time;
        this.empty_seats = empty_seats;
        this.arrival_date = arrival_date;
    }


    public static void TimeTable() throws IOException {
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight(
                    ++count,
                    Airline.getRandomAirline(),
                    Airline.getRandomCode()+(int)(Math.random()*100),
                    DepartureCity.KIEV,
                    ArrivalCity.getRandomCity(),
                    LocalTime.now().plusHours((long) (Math.random()*10)).plusMinutes((long) (Math.random()*20)).truncatedTo(ChronoUnit.SECONDS),
                    (int) (Math.random() * 100),
                    LocalDate.ofEpochDay(ThreadLocalRandom
                                    .current().nextInt(0, 365*5)));
            flights.add(flight);
        }
        writeToFile(flights);
    }

    public static void writeToFile(List<Flight> flights){
        try {
            File file = new File("flights.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flights);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File did't find");
        }
    }



    public Flight(ArrivalCity to, LocalDate arrival_date) {
        this.to = ArrivalCity.getRandomCity();
        this.arrival_date = arrival_date;
    }

    public int getId() {
        return id;
    }

    public ArrivalCity getFrom() {
        return ArrivalCity.getRandomCity();
    }

    public LocalDate getDate() {
        return arrival_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        return fmt.format(
                "%s %-3s %s %-5s %s %-20s %s %-12s %s %-15s %s %-12s %s %-15s %s %-3s %s",
                "|", id,
                "|", flightNo,
                "|", airline,
                "|", from,
                "|", to,
                "|", arrival_date.toString(),
                "|", arrival_time.toString(),
                "|", empty_seats,
                "|"
        ).toString();
    }
}
