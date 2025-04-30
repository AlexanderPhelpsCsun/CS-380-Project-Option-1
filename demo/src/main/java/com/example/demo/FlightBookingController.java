package com.example.demo;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Controller
public class FlightBookingController {
    List<Flight> flights = Flight.getAvailableFlights();
    
    
    @GetMapping("/book")
    public String bookFlights(@RequestParam(value = "sort", required = false) String sort, Model model) {

        if ("destination".equalsIgnoreCase(sort)) {
            flights.sort((f1, f2) -> f1.getDestination().compareToIgnoreCase(f2.getDestination()));
        } else if ("origin".equalsIgnoreCase(sort)) {
            flights.sort((f1, f2) -> f1.getOrigin().compareToIgnoreCase(f2.getOrigin()));
        }
        else if("flightID".equalsIgnoreCase(sort))
        {
            flights.sort((f1, f2) -> Integer.compare(f1.getFlightID(), f2.getFlightID()));
        }
       // else if("departureTime".equalsIgnoreCase(sort))
        

        model.addAttribute("flights", flights);
        return "book"; // renders book.html
    }

    @GetMapping("/book/{id}")
    public String showBookingForm(@PathVariable("id") Long id, Model model) {
    model.addAttribute("flightID", id);
    return "payment"; // Thymeleaf template name: payment.html
}


    @GetMapping("/login")
    public String loginPage(Model model) {
        
        return "login";  
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        Account account = database.findAccount(email);  // Find account by email
    
        if (account == null) {
            model.addAttribute("error", "Account not found.");
            System.out.print("accountnow found\n");
            return "login";  // Show the login page with error
        }
    
        try {
            // Hash the entered plain-text password
            String inputHash = Account.hash(password);
            String doubleHashedInput = Account.hash(inputHash); //not efficient but i dont wanna find the bug

            //inputHash = Account.hash(password);
    

            if (doubleHashedInput.equals(account.getpasswordHash())) {
                // Login successful, redirect to book page or dashboard
                return "redirect:/book";  // Redirect to your desired page
            } else {
                model.addAttribute("error", "Invalid credentials.");
                return "login";  // Invalid password, stay on login page
            }
        } catch (NoSuchAlgorithmException e) {
            model.addAttribute("error", "An error occurred during login.");
            return "login";  // Stay on login page in case of error
        }
    }





    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("account", new Account()); // form binding
        return "signup";  
    }
    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute Account account, Model model) {
        try {
            if (account.getPassword() == null || account.getPassword().isEmpty()) {
                model.addAttribute("error", "Password cannot be empty.");
                return "signup";
            }
    
            // Hash the plain-text password
            String hashedPassword = Account.hash(account.getPassword());
            account.setpasswordHash(hashedPassword);  // Store the hashed password
            database.addAccount(account);  // Store the account in the database
            return "redirect:/login";
        } catch (NoSuchAlgorithmException e) {
            model.addAttribute("error", "Signup failed.");
            return "signup";
        }
    }

    @PostMapping("/process-payment")
public String processPayment(@RequestParam int flightID, Model model) {
    Flight flight = database.getFlightbyID(flightID);
    model.addAttribute("flight", flight);
    return "confirmation"; // Thymeleaf view name
}








}




