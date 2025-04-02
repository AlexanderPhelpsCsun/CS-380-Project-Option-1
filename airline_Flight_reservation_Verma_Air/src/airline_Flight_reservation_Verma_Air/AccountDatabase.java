package airline_Flight_reservation_Verma_Air;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.*;

public class AccountDatabase {
    private HashMap<String, String> accounts; // Stores usernames and passwords

    // Helper methods to replace System.out.println() and System.out.print()
    public static void p(String message) {
        System.out.println(message);
    }

    public static void pr(String message) {
        System.out.print(message);
    }

    // Constructor to initialize the database
    public AccountDatabase() {
        accounts = new HashMap<>();
    }

    // Insert a new account
    public void insert(String username, String password) {
        if(accounts.containsKey(username)) {
            p("Error: Username '" + username + "' already exists!");
        } 
        else 
        {
            accounts.put(username, password);
            p("Account created successfully: " + username);
        }
    }


    // Search for an account
    public void search(String username) {
        if (accounts.containsKey(username)) {
            p("Account found: " + username);
        } else {
            p("Error: Account not found!");
        }
    }

    // Delete an account
    public void delete(String username) {
        if (accounts.containsKey(username)) {
            accounts.remove(username);
            p("Account '" + username + "' deleted.");
        } else {
            p("Error: Account not found!");
        }
    }

    // Display all accounts
    public void display() {
        if (accounts.isEmpty()) {
            p("No accounts in the database.");
        } else {
            p("Account Database: " + accounts);
        }
    }

    // Console menu
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
            pr("Choose an option: "); // Using pr() for inline input
            
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

