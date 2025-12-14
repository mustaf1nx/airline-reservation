public class Booking {

    private Flight flight;
    private Passenger passenger;
    private String bookingId;

    public Booking(String bookingId, Flight flight, Passenger passenger) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        passenger.displayInfo();
        flight.displayInfo();
    }
}
