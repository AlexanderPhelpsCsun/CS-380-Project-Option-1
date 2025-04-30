package csun.edu.valerie.flight_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import csun.edu.valerie.flight_reservation.entity.Traveler;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {

}
