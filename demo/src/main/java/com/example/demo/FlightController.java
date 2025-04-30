package com.example.demo;
import com.example.demo.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")  // Allow requests from any frontend
public class FlightController {

    /**
     * Returns a list of available flights using in-memory data.
     * This simulates a "search flights" feature.
     *
     * @return List of Flight objects
     */
    @GetMapping("/available")
    public List<Flight> getAvailableFlights() {
        return Flight.getAvailableFlights();
    }
}