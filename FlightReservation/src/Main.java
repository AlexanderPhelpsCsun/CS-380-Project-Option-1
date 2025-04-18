package flightreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Main class to run the Flight Reservation System.
 * It connects to the database, presents a menu, and calls other classes.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Connect to the database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlightReservation", "root", "DELSCORCHO2@y"))
        //Added { line below -AJP    
        {
            System.out.println("Connected to the database.");

            while (true) {
                System.out.println("\n===== Flight Reservation System =====");
                System.out.println("1. Add Traveler");
                System.out.println("2. Search Traveler by ID");
                System.out.println("3. View All Flights");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Phone: ");
                        String phone = scanner.nextLine();

                        Traveler newTraveler = new Traveler(name, email, phone);
                        newTraveler.insertTraveler(conn);
                        break;

                    case "2":
                        System.out.print("Enter Traveler ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Traveler found = Traveler.getTravelerByID(conn, id);
                        if (found != null) {
                            found.displayTraveler();
                        }
                        break;

                    case "3":
                        Flight.viewAllFlights(conn); // define method in Flight class
                        break;

                    case "4":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
}
