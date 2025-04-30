package csun.edu.valerie.flight_reservation.service;

import csun.edu.valerie.flight_reservation.entity.Booking;
import csun.edu.valerie.flight_reservation.entity.Flight;
import csun.edu.valerie.flight_reservation.entity.Traveler;
import csun.edu.valerie.flight_reservation.repository.BookingRepository;
import csun.edu.valerie.flight_reservation.repository.FlightRepository;
import csun.edu.valerie.flight_reservation.repository.TravelerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private final FlightRepository flightRepo;
    private final TravelerRepository travelerRepo;
    private final BookingRepository bookingRepo;

    public BookingService(FlightRepository flightRepo, TravelerRepository travelerRepo, BookingRepository bookingRepo) {
        this.flightRepo = flightRepo;
        this.travelerRepo = travelerRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<Flight> viewAvailableFlights() {
        return flightRepo.findAll();
    }

    public Booking bookFlight(Long travelerId, int flightId) {
        Traveler traveler = travelerRepo.findById(travelerId)
            .orElseThrow(() -> new RuntimeException("Traveler not found"));
        Flight flight = flightRepo.findById(flightId)
            .orElseThrow(() -> new RuntimeException("Flight not found"));

        if (flight.getSeatsAvail() <= 0) {
            throw new RuntimeException("No seats available for this flight.");
        }

        // Reduce seat count
        flight.setSeatsAvail(flight.getSeatsAvail() - 1);
        flightRepo.save(flight);

        Booking booking = new Booking(traveler, flight, LocalDate.now());
        return bookingRepo.save(booking);
    }
}
