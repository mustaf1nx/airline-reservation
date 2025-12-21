public class Passenger {

    private String fullName;
    private String passportNumber;

    public Passenger(String fullName, String passportNumber) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public void displayInfo() {
        System.out.println("  Name: " + fullName);
        System.out.println("  Passport: " + passportNumber);
    }

    public String toString() {
        return "Passenger{" +
                "fullName='" + fullName + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Passenger)) return false;
        Passenger other = (Passenger) obj;
        return passportNumber.equals(other.passportNumber);
    }

    public int hashCode() {
        return passportNumber.hashCode();
    }
}
