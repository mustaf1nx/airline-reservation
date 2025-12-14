public class Passenger {

    private String fullName;
    private String passportNumber;

    public Passenger(String fullName, String passportNumber) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void displayInfo() {
        System.out.println("Passenger: " + fullName +
                " | Passport: " + passportNumber);
    }
}
