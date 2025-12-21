public class Booking {

    private String bookingId;
    private Flight flight;
    private Passenger passenger;

    public Booking(String bookingId, Flight flight, Passenger passenger) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getBookingId() { return bookingId; }
    public Flight getFlight() { return flight; }
    public Passenger getPassenger() { return passenger; }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger Info:");
        passenger.displayInfo();
        System.out.println("Flight Info:");
        flight.displayInfo();
        System.out.println("------------------------------");
    }
    

    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Booking)) return false;
        Booking other = (Booking) obj;
        return bookingId.equals(other.bookingId);
    }

    public int hashCode() {
        return bookingId.hashCode();
    }
}