import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Flight flight1 = new Flight("KZ101", "Almaty", "Astana", 50000);
        Flight flight2 = new Flight("KZ102", "Almaty", "Shymkent", 45000);
        Flight flight3 = new Flight("KZ103", "Astana", "Shymkent", 48000);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        Passenger passenger1 = new Passenger("Azamat Mustafin", "N1234567");
        VIPPassenger passenger2 = new VIPPassenger("Aigerim Beket", "P9876543", 10);

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passenger1);
        passengers.add(passenger2);

        Booking booking1 = new Booking("B001", flight1, passenger1);
        Booking booking2 = new Booking("B002", flight2, passenger2);

        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);

        System.out.println("\n=== ALL BOOKINGS ===");
        bookings.forEach(Booking::displayBooking);

        System.out.println("\n=== FLIGHTS SORTED BY PRICE ===");
        flights.sort(Comparator.comparingDouble(Flight::getPrice));
        flights.forEach(Flight::displayInfo);

        System.out.println("\n=== CHEAP FLIGHTS (< 49000) ===");
        List<Flight> cheapFlights = flights.stream()
                .filter(f -> f.getPrice() < 49000)
                .collect(Collectors.toList());
        cheapFlights.forEach(Flight::displayInfo);

        String searchNumber = "KZ102";
        System.out.println("\n=== SEARCH FLIGHT BY NUMBER: " + searchNumber + " ===");
        flights.stream()
                .filter(f -> f.getFlightNumber().equals(searchNumber))
                .forEach(Flight::displayInfo);
    }
}