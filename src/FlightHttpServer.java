import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FlightHttpServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/flights", new FlightHandler());

        server.start();
        System.out.println("Server started on port 8080");
    }

    static class FlightHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) {
            try {
                if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                    exchange.sendResponseHeaders(405, -1); // Method Not Allowed
                    return;
                }

                FlightDAO dao = new FlightDAO();
                List<Flight> flights = dao.getAllFlights();

                // Построение JSON
                StringBuilder json = new StringBuilder();
                json.append("[");
                for (int i = 0; i < flights.size(); i++) {
                    Flight f = flights.get(i);
                    json.append("{")
                        .append("\"flightNumber\":\"").append(f.getFlightNumber() != null ? f.getFlightNumber() : "").append("\",")
                        .append("\"origin\":\"").append(f.getOrigin() != null ? f.getOrigin() : "").append("\",")
                        .append("\"destination\":\"").append(f.getDestination() != null ? f.getDestination() : "").append("\",")
                        .append("\"price\":").append(f.getPrice())
                        .append("}");
                    if (i != flights.size() - 1) {
                        json.append(",");
                    }
                }
                json.append("]");

                exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                byte[] responseBytes = json.toString().getBytes(StandardCharsets.UTF_8);

                exchange.sendResponseHeaders(200, responseBytes.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(responseBytes);
                }

            } catch (Exception e) {
                e.printStackTrace();
                try {
                    String errorJson = "{\"error\":\"" + e.getMessage() + "\"}";
                    exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
                    byte[] responseBytes = errorJson.getBytes(StandardCharsets.UTF_8);
                    exchange.sendResponseHeaders(500, responseBytes.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseBytes);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
