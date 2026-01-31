import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    public void addFlight(Flight flight) {
        String sql = """
            INSERT INTO flights (flight_number, origin, destination, price)
            VALUES (?, ?, ?, ?)
        """;
    
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getOrigin());
            ps.setString(3, flight.getDestination());
            ps.setDouble(4, flight.getPrice());
            ps.executeUpdate();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                flights.add(new Flight(
                        rs.getString("flight_number"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    public void updatePrice(String flightNumber, double newPrice) {
        String sql = "UPDATE flights SET price = ? WHERE flight_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, newPrice);
            ps.setString(2, flightNumber);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFlight(String flightNumber) {
        String sql = "DELETE FROM flights WHERE flight_number = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, flightNumber);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}