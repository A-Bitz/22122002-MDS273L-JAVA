

import java.sql.*;
import java.util.Scanner;

public class BusBookingSystems{

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement loginStmt = null;
        PreparedStatement busesStmt = null;
        PreparedStatement seatsStmt = null;
        PreparedStatement bookStmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root", "5101");

            // Prepare statements
            loginStmt = conn.prepareStatement("SELECT * FROM customers WHERE username = ? AND password = ?");
            busesStmt = conn.prepareStatement("SELECT * FROM buses WHERE source = ? AND destination = ?");
            seatsStmt = conn.prepareStatement("SELECT seats_available FROM buses WHERE bus_id = ?");
            bookStmt = conn.prepareStatement("INSERT INTO bookings (customer_id, bus_id, no_of_seats, total_fare) VALUES (?, ?, ?, ?)");

            // Get input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Validate user credentials
            loginStmt.setString(1, username);
            loginStmt.setString(2, password);
            rs = loginStmt.executeQuery();

            if (rs.next()) {
                // User is authenticated, proceed with booking
                System.out.print("Enter source: ");
                String source = scanner.nextLine();
                System.out.print("Enter destination: ");
                String destination = scanner.nextLine();

                // Retrieve available buses
                busesStmt.setString(1, source);
                busesStmt.setString(2, destination);
                rs = busesStmt.executeQuery();

                while (rs.next()) {
                    int busId = rs.getInt("bus_id");
                    String busName = rs.getString("bus_name");
                    int seatsAvailable = rs.getInt("seats_available");
                    int fare = rs.getInt("fare");
                    System.out.println("Bus ID: " + busId + ", Bus Name: " + busName + ", Seats Available: " + seatsAvailable + ", Fare: " + fare);
                }

                // Book a bus
                System.out.print("Enter bus ID: ");
                int busId = scanner.nextInt();
                System.out.print("Enter number of seats: ");
                int noOfSeats = scanner.nextInt();

                // Check if there are enough seats available
                seatsStmt.setInt(1, busId);
                rs = seatsStmt.executeQuery();
                if (rs.next()) {
                    int seatsAvailable = rs.getInt("seats_available");
                    if (noOfSeats <= seatsAvailable) {
                        // Calculate total fare and update booking table
                        int totalFare = noOfSeats * rs.getInt("fare");
                        int customerId = rs.getInt("customer_id");
                        bookStmt.setInt(1, customerId);
                        bookStmt.setInt(2, busId);
                        bookStmt.setInt(3, noOfSeats);
                        bookStmt.setInt(4, totalFare);
                        bookStmt.executeUpdate();
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
                if (seatsStmt != null) seatsStmt.close();
                if (bookStmt != null) bookStmt.close();
                if (conn != null) conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
}
}
}
}

