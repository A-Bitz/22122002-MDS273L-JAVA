package Projects;
import java.sql.*;
import java.util.Scanner;

public class BusBookingSystem {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root", "5101");

            // Get input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Validate user credentials
            String sql = "SELECT * FROM customers WHERE username = '" + username + "' AND password = '" + password + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // User is authenticated, proceed with booking
                System.out.print("Enter source: ");
                String source = scanner.nextLine();
                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();

                // Retrieve available buses
                int fare = 0; // declare the fare variable
                sql = "SELECT * FROM buses WHERE source = '" + source + "' AND destination = '" + destination + "'";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int busId = rs.getInt("bus_id");
                    String busName = rs.getString("bus_name");
                    int seatsAvailable = rs.getInt("seats_available");
                    fare = rs.getInt("fare"); // assign the fare variable
                    System.out.println("Bus ID: " + busId + ", Bus Name: " + busName + ", Seats Available: " + seatsAvailable + ", Fare: " + fare);
                }

                // Book a bus
                System.out.print("Enter bus ID: ");
                int busId = scanner.nextInt();
                System.out.print("Enter number of seats: ");
                int noOfSeats = scanner.nextInt();

                // Check if there are enough seats available
                rs = stmt.executeQuery("SELECT seats_available FROM buses WHERE bus_id = " + busId);
                if (rs.next()) {
                    int seatsAvailable = rs.getInt("seats_available");
                    if (noOfSeats <= seatsAvailable) {
                        // Calculate total fare and update booking table
                        int totalFare = noOfSeats * fare;
                        int customerId = rs.getInt("customer_id");
                        sql = "INSERT INTO bookings (customer_id, bus_id, no_of_seats, total_fare) VALUES (" + customerId + ", " + busId + ", " + noOfSeats + ", " + totalFare + ")";
                        stmt.executeUpdate(sql);
                        System.out.println("Booking confirmed! Total fare: " + totalFare);
                    } else {
                        System.out.println("Sorry, there are not enough seats available on this bus.");
                    }
                }
            } else {
                // User authentication failed
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
