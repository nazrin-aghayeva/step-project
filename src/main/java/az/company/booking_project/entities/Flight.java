package az.company.booking_project.entities;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Flight implements Serializable {
    private static Random random= new Random();

    private int id;
    private Airline airline;
    private String flightNo;
    private DepartureCity from;
    private ArrivalCity to;
    private LocalDate arrival_date;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    private int empty_seats;
    private static int count = 0;
    static List<Flight> flights = new ArrayList<>();


    public Flight(int id,Airline airline,String flightNo, DepartureCity from, ArrivalCity to, int empty_seats, LocalDateTime departure_time,LocalDateTime arrival_time) {
        this.id = id;
        this.airline=airline;
        this.flightNo=flightNo;
        this.from = from;
        this.to = to;
        this.departure_time= departure_time;
        this.empty_seats = empty_seats;
         this.arrival_time=arrival_time;
    }

//    public Flight(int id,Airline airline,String flightNo, DepartureCity from, ArrivalCity to, int empty_seats, LocalDateTime departure_time, LocalDateTime arrival_time) {
//        this.id = id;
//        this.airline=airline;
//        this.flightNo=flightNo;
//        this.from = from;
//        this.to = to;
//        this.departure_time= departure_time;
//        this.empty_seats = empty_seats;
//    }

    public static void TimeTable() throws IOException {
        for (int i = 0; i < 20; i++) {
            Flight flight = new Flight(
                    ++count,
                    Airline.getRandomAirline(),
                    Airline.getRandomCode()+(int)(Math.random()*100),
                    DepartureCity.KIEV,
                    ArrivalCity.getRandomCity(),
                    (int) (Math.random() * 100),
                    LocalDateTime.of(LocalDate.now(),LocalTime.of(random.nextInt(24), (random.nextInt(60)/30)*30)),
                    LocalDateTime.of(LocalDate.now(),LocalTime.of(random.nextInt(24), (random.nextInt(60)/30)*30)).plusHours(ThreadLocalRandom.current().nextInt(2, 6))
                    );
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


    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        LocalDate dateFromDateTime=arrival_time.toLocalDate();
       return dateFromDateTime;
    }

    public ArrivalCity getTo() {
        return to;
    }


    public Flight(ArrivalCity to, LocalDateTime arrival_time) {
        this.to=to;
        this.arrival_time=arrival_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

//            this.arrival_time= departure_time.plusHours(ThreadLocalRandom.current().nextInt(2, 6));
            return fmt.format(
                "%s %-3s %s %-5s %s %-20s %s %-12s %s %-15s %s %-12s %s %-15s %s %-3s %s",
                "|", id,
                "|", flightNo,
                "|", airline,
                "|", from,
                "|", departure_time.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")),
                "|", to,
                "|", arrival_time.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")),
                "|", empty_seats,
                "|"
        ).toString();
    }
}
