package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*")
public class FlightController {

    @GetMapping(value = { "", "/available" })
    public List<Flight> getAvailableFlights() {
        return Flight.getAvailableFlights();
    }
}