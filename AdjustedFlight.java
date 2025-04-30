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
 *
*@author Valerie Chavez
 */

package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Flight {
    private int flightID;
    private String flightNumber;
    private String destination;
    private int seatsAvail;
    private String departureTime;
    private String arrivalTime;
    private String origin;

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
                  String departureTime, String arrivalTime, String origin) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.seatsAvail = seatsAvail;
        this.departureTime = departureTime;
        this.origin = origin;
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


    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public static List<Flight> getAvailableFlights() 
    {
        List<Flight> flights = new ArrayList<>();
        String[] destinations = {
                "New York", "London", "Tokyo", "Paris", "Dubai", "Toronto", "Berlin", "Sydney", "Los Angeles",
                "Chicago", "San Francisco", "Beijing", "Shanghai", "Seoul", "Rome", "Madrid", "Barcelona",
                "Lisbon", "Vienna", "Amsterdam", "Brussels", "Copenhagen", "Oslo", "Stockholm", "Helsinki",
                "Istanbul", "Athens", "Bangkok", "Singapore", "Hong Kong", "Kuala Lumpur", "Jakarta",
                "Mumbai", "Delhi", "Doha", "Abu Dhabi", "Cape Town", "Johannesburg", "Mexico City",
                "Buenos Aires", "Lima", "Santiago", "Rio de Janeiro", "Sao Paulo", "Bogotá", "Panama City",
                "Caracas", "Cairo", "Nairobi", "Casablanca", "Riyadh", "Manila", "Taipei", "Hanoi",
                "Ho Chi Minh City", "Auckland", "Wellington", "Melbourne", "Perth", "Brisbane", "Montreal",
                "Vancouver", "Quebec City", "Edmonton", "Calgary", "Ottawa", "Honolulu", "San Diego",
                "Seattle", "Portland", "Boston", "Philadelphia", "Miami", "Atlanta", "Houston", "Dallas",
                "Denver", "Phoenix", "Las Vegas", "Salt Lake City", "Minneapolis", "Detroit", "Charlotte",
                "Orlando", "Tampa", "Pittsburgh", "Cleveland", "Cincinnati", "St. Louis", "Kansas City",
                "New Orleans", "Anchorage", "Fairbanks", "Reykjavik", "Zurich", "Geneva", "Munich", "Frankfurt",
                "Prague", "Warsaw", "Budapest", "Belgrade", "Bucharest", "Luxembourg", "Ljubljana", "Tallinn",
                "Riga", "Vilnius", "Dubrovnik", "Split", "Sofia", "Skopje", "Sarajevo"
            };
        int flightAmount = ThreadLocalRandom.current().nextInt(3, 50); 
        for(int i  = 0; i < flightAmount; i++)
        {
            String flightId = "xxx";
            String destination = destinations[ThreadLocalRandom.current().nextInt(destinations.length)];
            String origin = destinations[ThreadLocalRandom.current().nextInt(destinations.length)];
            int seatsAvail = ThreadLocalRandom.current().nextInt(10, 150);
            String departureTime = getRandomTime();
            String arrivalTime = getRandomTime2(departureTime);

            flights.add(new Flight(i, flightId, destination, seatsAvail, departureTime, arrivalTime, origin));
        }
        return flights;
    }

    private static String getRandomTime() {
        int hour = ThreadLocalRandom.current().nextInt(0, 24);
        int minute = ThreadLocalRandom.current().nextInt(0, 60);
        String suffix = hour < 12 ? "AM" : "PM";
        int displayHour = hour % 12 == 0 ? 12 : hour % 12;
        return String.format("%02d:%02d %s", displayHour, minute, suffix);
    }
    
    private static String getRandomTime2(String departureTime) {
        // Extract hour and minute from departureTime 
        String[] parts = departureTime.split("[: ]");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String period = parts[2];
    
        // Convert to 24-hour time
        if (period.equals("PM") && hour != 12) {
            hour += 12;
        } else if (period.equals("AM") && hour == 12) {
            hour = 0;
        }
    
        // Add 2–8 hours
        int addedHours = ThreadLocalRandom.current().nextInt(2, 9);
        hour += addedHours;
    
        // Wrap around 24-hour time
        hour = hour % 24;
    
        // Re-convert to 12-hour format
        String suffix = hour < 12 ? "AM" : "PM";
        int displayHour = hour % 12 == 0 ? 12 : hour % 12;
    
        return String.format("%02d:%02d %s", displayHour, minute, suffix);
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
