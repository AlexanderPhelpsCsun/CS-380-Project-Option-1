package csun.edu.valerie.flight_reservation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csun.edu.valerie.flight_reservation.entity.Booking;
import csun.edu.valerie.flight_reservation.entity.Flight;
import csun.edu.valerie.flight_reservation.service.BookingService;

@RestController
@RequestMapping("/api/traveler")
public class TravelerController {

    private final BookingService bookingService;

    public TravelerController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return bookingService.viewAvailableFlights();
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookFlight(@RequestParam Long travelerId, @RequestParam int flightId) {
        try {
            Booking booking = bookingService.bookFlight(travelerId, flightId);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}