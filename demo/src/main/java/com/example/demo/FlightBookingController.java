package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightBookingController {

    @GetMapping("/book")
    public String bookFlights(Model model) {
        // Add any dynamic attributes to the model if necessary
        return "book";  // Thymeleaf will render book.html in the templates directory
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