/**
 * Module/Class Name: Flight
 * Date: April 14, 2025
 * Programmer: Valerie Chavez
 *
 * Description:
 * This class represents a flight in the flight reservation system.
 * It stores all relevant flight information, such as flight ID, flight number,
 * destination, seats available, and optionally, departure and arrival times.
 *
 * Key Functions:
 * - Constructor to initialize flight details
 * - Getter and Setter methods for accessing and updating flight data
 *
 * Data Structures:
 * - Uses primitive types and String to store flight data.
 */

*@author Valerie Chavez
 */
public class Flight {
    private int flightID;
    private String flightNumber;
    private String destination;
    private int seatsAvail;
    private String departureTime;
    private String arrivalTime;

    /**
     * Constructs a Flight object with all the required attributes.
     *
     * @param flightID The unique identifier for the flight.
     * @param flightNumber The flight number (e.g., "AA123").
     * @param destination The destination city or airport.
     * @param seatsAvail The number of seats currently available on the flight.
     * @param departureTime The scheduled departure time.
     * @param arrivalTime The scheduled arrival time.
     * @author Valerie Chavez
     */
    public Flight(int flightID, String flightNumber, String destination, int seatsAvail,
                  String departureTime, String arrivalTime) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.seatsAvail = seatsAvail;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    /** @return the flightID. */
    public int getFlightID() {
        return flightID;
    }

    /**
     * Sets the flight's ID.
     *
     * @param flightID the new ID for the flight.
     */
    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    /** @return the flight number. */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the flight number.
     *
     * @param flightNumber the new flight number.
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /** @return the destination of the flight. */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the flight destination.
     *
     * @param destination the new destination.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /** @return the number of available seats. */
    public int getSeatsAvail() {
        return seatsAvail;
    }

    /**
     * Sets the number of seats available.
     *
     * @param seatsAvail the new number of available seats.
     */
    public void setSeatsAvail(int seatsAvail) {
        this.seatsAvail = seatsAvail;
    }

    /** @return the departure time. */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the departure time for the flight.
     *
     * @param departureTime the new departure time.
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /** @return the arrival time. */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time for the flight.
     *
     * @param arrivalTime the new arrival time.
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns a string representation of the flight.
     *
     * @return formatted string with all flight details.
     */
    @Override
    public String toString() {
        return "Flight ID: " + flightID +
               ", Number: " + flightNumber +
               ", Destination: " + destination +
               ", Seats Available: " + seatsAvail +
               ", Departure: " + departureTime +
               ", Arrival: " + arrivalTime;
    }
}