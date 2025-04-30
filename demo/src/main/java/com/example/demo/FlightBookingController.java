package com.example.demo;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.NoSuchAlgorithmException;


@Controller
public class FlightBookingController {

    @GetMapping("/book")
    public String bookFlights(Model model) {
        List<Flight> flights = Flight.getAvailableFlights();
        model.addAttribute("flights", flights);
        return "book"; // renders book.html
    }

    


    @GetMapping("/login")
    public String loginPage(Model model) {
        
        return "login";  
    }
    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("account", new Account()); // form binding
        return "signup";  
    }
    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute Account account, Model model) {
        try {

            String hashedPassword = Account.hash(account.getpasswordHash());
            account.setpasswordHash(hashedPassword);
            database.addAccount(account);
            return "redirect:/login";
        } catch (NoSuchAlgorithmException e) {
            model.addAttribute("error", "Error during account creation.");
            return "signup"; // Stay on the signup page in case of error
        }
    }
}




