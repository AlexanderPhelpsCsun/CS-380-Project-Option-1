/**
 * The {@code AccountDatabase} class provides basic functionality
 * for creating, searching, deleting, and displaying user accounts
 * using a simple in-memory {@code HashMap}.
 * <p>
 * It includes a text-based console menu interface for interacting with the database.
 * 
 * <p><b>Package:</b> airline_Flight_reservation_Verma_Air
 * 
 * @author Itzcoatl Tellez, Group 4
 */
package airline_Flight_reservation_Verma_Air;

import java.util.HashMap;
import java.util.Scanner;

/**
 * A class that manages a simple account database using a HashMap.
 */
public class AccountDatabase {
    /** Stores usernames and their corresponding passwords. */
    private HashMap<String, String> accounts;

    /**
     * Prints a message followed by a newline.
     *
     * @param message the message to print
     */
    public static void p(String message) {
        System.out.println(message);
    }

    /**
     * Prints a message without a newline (inline input).
     *
     * @param message the message to print
     */
    public static void pr(String message) {
        System.out.print(message);
    }

    /**
     * Constructs a new AccountDatabase with an empty account list.
     */
    public AccountDatabase() {
        accounts = new HashMap<>();
    }

    /**
     * Inserts a new account into the database.
     *
     * @param username the username to insert
     * @param password the password for the username
     */
    public void insert(String username, String password) {
        if(accounts.containsKey(username)) {
            p("Error: Username '" + username + "' already exists!");
        } else {
            accounts.put(username, password);
            p("Account created successfully: " + username);
        }
    }

    /**
     * Searches for an account by username.
     *
     * @param username the username to search
     */
    public void search(String username) {
        if (accounts.containsKey(username)) {
            p("Account found: " + username);
        } else {
            p("Error: Account not found!");
        }
    }

    /**
     * Deletes an account by username.
     *
     * @param username the username to delete
     */
    public void delete(String username) {
        if (accounts.containsKey(username)) {
            accounts.remove(username);
            p("Account '" + username + "' deleted.");
        } else {
            p("Error: Account not found!");
        }
    }

    /**
     * Displays all accounts in the database.
     */
    public void display() {
        if (accounts.isEmpty()) {
            p("No accounts in the database.");
        } else {
            p("Account Database: " + accounts);
        }
    }

    /**
     * The main method providing a console-based interface
     * for interacting with the AccountDatabase.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AccountDatabase accountDB = new AccountDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Console menu
            p("\n===== Account Database Menu =====");
            p("1. Create Account");
            p("2. Search Account");
            p("3. Delete Account");
            p("4. Display Accounts");
            p("5. Exit");
            pr("Choose an option: ");

            String choice = scanner.next();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case "1": // Insert
                    pr("Enter username: ");
                    String username = scanner.nextLine();
                    pr("Enter password: ");
                    String password = scanner.nextLine();
                    accountDB.insert(username, password);
                    break;

                case "2": // Search
                    pr("Enter username to search: ");
                    String searchUser = scanner.nextLine();
                    accountDB.search(searchUser);
                    break;

                case "3": // Delete
                    pr("Enter username to delete: ");
                    String deleteUser = scanner.nextLine();
                    accountDB.delete(deleteUser);
                    break;

                case "4": // Display
                    accountDB.display();
                    break;

                case "5": // Exit
                    p("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    p("Invalid option! Please try again.");
            }
        }
    }
}

