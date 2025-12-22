public class Flight {

    private String flightNumber;
    private String origin;
    private String destination;
    private double price;

    public Flight(String flightNumber, String origin, String destination, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        setPrice(price);
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("  Flight Number: " + flightNumber);
        System.out.println("  From: " + origin);
        System.out.println("  To: " + destination);
        System.out.println("  Price: " + price + "\n");
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Flight)) return false;
        Flight other = (Flight) obj;
        return flightNumber.equals(other.flightNumber);
    }

    @Override
    public int hashCode() {
        return flightNumber.hashCode();
    }
}