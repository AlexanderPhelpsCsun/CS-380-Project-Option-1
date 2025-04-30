/**
 * Module/Class Name: Flight
 * Date: April 29, 2025
 * Programmer: Valerie Chavez
 *
 * Description:
 * This class represents a flight in the flight reservation system.
 * It stores flight information such as flight number, destination,
 * seats available, origin, and departure/arrival times.
 *
 * Key Functions:
 * - Stores flight details
 * - Provides static method to generate a list of random available flights
 *
 * Data Structures:
 * - Uses primitive types and String for internal storage
 * - Uses List<Flight> to return mock flight data
 *
 * Note:
 * This version does not use a SQL database and stores data in-memory only.
 *
 * @author Valerie Chavez
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

    public Flight(int flightID, String flightNumber, String destination, int seatsAvail,
                  String departureTime, String arrivalTime, String origin) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.seatsAvail = seatsAvail;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.origin = origin;
    }

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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Generates a random list of available flights with dummy data.
     * This simulates fetching from a database but is in-memory only.
     *
     * @return List of randomly generated flights.
     */
    public static List<Flight> getAvailableFlights() {
        List<Flight> flights = new ArrayList<>();
        String[] cities = {
            "New York", "London", "Tokyo", "Paris", "Dubai", "Toronto", "Berlin", "Sydney", "Los Angeles",
            "Chicago", "San Francisco", "Beijing", "Rome", "Madrid", "Amsterdam", "Seoul", "Mumbai"
        };
        int flightAmount = ThreadLocalRandom.current().nextInt(3, 10);

        for (int i = 0; i < flightAmount; i++) {
            String flightNumber = "FL" + ThreadLocalRandom.current().nextInt(100, 999);
            String destination = cities[ThreadLocalRandom.current().nextInt(cities.length)];
            String origin = cities[ThreadLocalRandom.current().nextInt(cities.length)];
            int seatsAvail = ThreadLocalRandom.current().nextInt(10, 150);
            String departureTime = getRandomTime();
            String arrivalTime = getRandomArrivalTime(departureTime);

            flights.add(new Flight(i, flightNumber, destination, seatsAvail, departureTime, arrivalTime, origin));
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

    private static String getRandomArrivalTime(String departureTime) {
        String[] parts = departureTime.split("[: ]");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String period = parts[2];

        if (period.equals("PM") && hour != 12) hour += 12;
        if (period.equals("AM") && hour == 12) hour = 0;

        hour = (hour + ThreadLocalRandom.current().nextInt(2, 8)) % 24;

        String suffix = hour < 12 ? "AM" : "PM";
        int displayHour = hour % 12 == 0 ? 12 : hour % 12;
        return String.format("%02d:%02d %s", displayHour, minute, suffix);
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightID +
               ", Number: " + flightNumber +
               ", Origin: " + origin +
               ", Destination: " + destination +
               ", Seats: " + seatsAvail +
               ", Departure: " + departureTime +
               ", Arrival: " + arrivalTime;
    }
}