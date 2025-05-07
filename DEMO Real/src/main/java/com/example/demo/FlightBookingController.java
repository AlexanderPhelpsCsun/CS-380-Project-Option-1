package com.example.demo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class FlightBookingController {

    List<Flight> flights = FlightHelper.getAvailableFlights();
    
    @PostMapping("/remove-flight")
    public String removeFlight(@RequestParam("pflightID") int pflightID)
    {
        if(pflightID > flights.size())
        {
            return "redirect:/manager";
        }

        flights.remove(pflightID);
        return "redirect:/manager";
    }





    @GetMapping("/view")
        public String viewFlights(@RequestParam(value = "sort", required = false) String sort, Model model)
        {
            List<Flight> sortedFlights = new ArrayList<>(flights);
        if ("destination".equalsIgnoreCase(sort)) 
        {
            sortedFlights.sort((f1, f2) -> f1.getDestination().compareToIgnoreCase(f2.getDestination()));
        } 
        else if ("origin".equalsIgnoreCase(sort)) 
        {
            sortedFlights.sort((f1, f2) -> f1.getOrigin().compareToIgnoreCase(f2.getOrigin()));
        }
        else if("flightID".equalsIgnoreCase(sort))
        {
            sortedFlights.sort((f1, f2) -> Integer.compare(f1.getFlightID(), f2.getFlightID()));
        }
            model.addAttribute("flights", sortedFlights);
            return "view";
        }



    @GetMapping("/book")
    public String bookFlights(@RequestParam(value = "sort", required = false) String sort, Model model,  HttpSession session) 
    {

        List<Flight> sortedFlights = new ArrayList<>(flights);
        if ("destination".equalsIgnoreCase(sort)) 
        {
            sortedFlights.sort((f1, f2) -> f1.getDestination().compareToIgnoreCase(f2.getDestination()));
        } 
        else if ("origin".equalsIgnoreCase(sort)) 
        {
            sortedFlights.sort((f1, f2) -> f1.getOrigin().compareToIgnoreCase(f2.getOrigin()));
        }
        else if("flightID".equalsIgnoreCase(sort))
        {
            sortedFlights.sort((f1, f2) -> Integer.compare(f1.getFlightID(), f2.getFlightID()));
        }
        else if("cost".equalsIgnoreCase(sort))
        {
            sortedFlights.sort((f1, f2) -> Integer.compare(f1.getCost(), f2.getCost()));
        }
       // else if("departureTime".equalsIgnoreCase(sort))
        
        model.addAttribute("flights", sortedFlights);
        return "book"; // renders book.html
    }

    @GetMapping("/book/{id}")
    public String showBookingForm(@PathVariable("id") int id, Model model, HttpSession session) 
    {

        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if(isLoggedIn == null || !isLoggedIn)
        {
            return "redirect:/login";
        }


        model.addAttribute("flightID", id);
        return "payment"; // Thymeleaf template name: payment.html
    }





    @GetMapping("/login")
    public String loginPage(Model model) {
        
        return "login";  
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        Account account = database.findAccount(email);  // Find account by email
    
        if (account == null) {
            model.addAttribute("error", "Account not found.");
            System.out.print("accountnow found\n");
            return "login"; 
        }
    
        try {
            // Hash the entered plain-text password
            String inputHash = Account.hash(password);
            String doubleHashedInput = Account.hash(inputHash); //not efficient but i dont wanna find the bug

            //inputHash = Account.hash(password);
    

            if (doubleHashedInput.equals(account.getpasswordHash())) {
                // Login successful, redirect to book page or dashboard
                session.setAttribute("isLoggedIn", true);
                session.setAttribute("userEmail", email);
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

@Autowired
private EmailService emailService;  // Inject the EmailService
@PostMapping("/process-payment")
public String processPayment(@RequestParam int flightID, Model model, HttpSession session) {
    // Fetch the flight using the flightID
    Flight selectedFlight = null;
    
    // Check if flights list contains the flight with the specified ID
    for (Flight flight : flights) {
        if (flight.getFlightID() == flightID) {
            selectedFlight = flight;
            break;
        }
    }

    // Ensure the selected flight exists
    if (selectedFlight == null) {
        model.addAttribute("error", "Flight not found.");
        return "redirect:/book";  // Redirect back to book page if not found
    }

    // Get user account and process payment logic
    String userEmail = (String) session.getAttribute("userEmail");
    Account account = database.findAccount(userEmail);

    if (account != null) {
        // Add the selected flight to the user's account
        account.setTickets(selectedFlight);
        database.addAccount(account);

        // Send confirmation email
        String flightDetails = "Flight Number: " + selectedFlight.getFlightNumber() + "\n" +
                               "Origin: " + selectedFlight.getOrigin() + "\n" +
                               "Destination: " + selectedFlight.getDestination() + "\n" +
                               "Departure Time: " + selectedFlight.getDepartureTime() + "\n" +
                               "Cost: $" + selectedFlight.getCost();
        emailService.sendConfirmationEmail(userEmail, flightDetails);

        model.addAttribute("flight", selectedFlight);
        return "confirmation";  // Redirect to confirmation page
    }

    model.addAttribute("flight", selectedFlight);
    return "confirmation";  // If no account found, just return confirmation page anyway
}

Manager manager = new Manager();
int revenue = manager.showRevenue((ArrayList<Flight>) flights);
@GetMapping("/manager")
public String showManagerPage(Model model) {
    
    
    model.addAttribute("revenue", revenue);
    model.addAttribute("flights", flights); 
    return "manager";
}


@PostMapping("/change-cost")
public String changeCost(@RequestParam("flightID") int flightID,
                         @RequestParam("newCost") int newCost) {
    Manager manager = new Manager();
    manager.changeCost((ArrayList<Flight>) flights, flightID, newCost);
    return "redirect:/manager";
}


@GetMapping("/account")
public String showAccountPage(HttpSession session, Model model) {
    String email = (String) session.getAttribute("userEmail");
    if (email == null) {
        return "redirect:/login";
    }

    Account account = database.findAccount(email);
    if (account == null) {
        return "redirect:/login";
    }

    ArrayList<Flight> bookedFlight = account.getTickets();  

    model.addAttribute("account", account);
    model.addAttribute("flight", bookedFlight);
    return "account"; // account.html
}








@PostMapping("/cancel-flight")
public String cancelFlight(@RequestParam String flightNumber, HttpSession session) {
    String email = (String) session.getAttribute("userEmail");
    Account account = database.findAccount(email); // always fetch from DB

    if (account != null) {
        account.getTickets().removeIf(flight -> flight.getFlightNumber().equals(flightNumber));
        database.addAccount(account); // update saved data (replace with updateAccount if you have one)
    }

    return "redirect:/account";
}





}




