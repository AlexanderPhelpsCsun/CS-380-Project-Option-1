package csun.edu.valerie.flight_reservation.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import csun.edu.valerie.flight_reservation.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
