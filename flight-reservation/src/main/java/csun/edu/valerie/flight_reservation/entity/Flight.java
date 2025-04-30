package csun.edu.valerie.flight_reservation.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Flight {

    @Id
    private int flightID;

    private String flightNumber;
    private String destination;
    private int seatsAvail;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private BigDecimal price;

    // Constructors
    public Flight() {}

    public Flight(int flightID, String flightNumber, String destination, int seatsAvail,
                  LocalTime departureTime, LocalTime arrivalTime, BigDecimal price) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.seatsAvail = seatsAvail;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    // Getters and Setters
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSeatsAvail() {
        return seatsAvail;
    }

    public void setSeatsAvail(int seatsAvail) {
        this.seatsAvail = seatsAvail;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

