public class VIPPassenger extends Passenger {

    private double discountRate;

    public VIPPassenger(String fullName, String passportNumber, double discountRate) {
        super(fullName, passportNumber);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("  VIP Discount: " + discountRate + "%");
    }

    public String toString() {
        return super.toString() + " | VIP Discount=" + discountRate + "%";
    }
}

