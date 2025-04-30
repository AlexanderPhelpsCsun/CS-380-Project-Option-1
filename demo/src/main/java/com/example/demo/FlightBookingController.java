package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        
        return "signup";  
    }




}