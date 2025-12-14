public class Main {

    public static void main(String[] args) {

        Flight flight1 = new Flight("KZ101", "Almaty", "Astana", 50000);
        Flight flight2 = new Flight("KZ102", "Almaty", "Shymkent", 45000);

        Passenger passenger1 = new Passenger("Azamat Mustafin", "N1234567");

        Booking booking1 = new Booking("B001", flight1, passenger1);

        System.out.println("=== BOOKING INFORMATION ===");
        booking1.displayBooking();

        System.out.println("\n=== FLIGHT PRICE COMPARISON ===");
        if (flight1.getPrice() > flight2.getPrice()) {
            System.out.println("Flight " + flight1.getFlightNumber() + " is more expensive.");
        } else {
            System.out.println("Flight " + flight2.getFlightNumber() + " is more expensive.");
        }
    }
}
