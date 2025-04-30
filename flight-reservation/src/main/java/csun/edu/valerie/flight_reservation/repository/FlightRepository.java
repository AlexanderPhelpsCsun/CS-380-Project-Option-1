package csun.edu.valerie.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import csun.edu.valerie.flight_reservation.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
