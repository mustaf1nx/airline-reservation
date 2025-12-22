public class VIPPassenger extends Passenger {

    private double discountRate;

    public VIPPassenger(String fullName, String passportNumber, double discountRate) {
        super(fullName, passportNumber);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  VIP Discount: " + discountRate + "%");
    }

    @Override
    public String toString() {
        return super.toString() + " | VIP Discount=" + discountRate + "%";
    }
}

