package com.example.demo;


import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class FlightHelper {
    private static final SecureRandom random = new SecureRandom();

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    
    public static List<Flight> getAvailableFlights() 
    {
        List<Flight> flights = new ArrayList<>();
        String[] destinations = {
                "New York", "London", "Tokyo", "Paris", "Dubai", "Toronto", "Berlin", "Sydney", "Los Angeles",
                "Chicago", "San Francisco", "Beijing",
                 "Amsterdam",   "Hong Kong",   "Montreal",
                "Vancouver",  "Honolulu", "San Diego",
                "Seattle", "Portland", "Boston", "Philadelphia", "Miami", "Atlanta", "Houston", "Dallas",
                "Denver", "Phoenix", "Las Vegas", "Salt Lake City", "Minneapolis", "Detroit",
                "Orlando", "Tampa", "Pittsburgh", "Cleveland", "Cincinnati", "St. Louis", "Kansas City",
                "New Orleans", "Anchorage",   "Munich", "Frankfurt",

            };
        int flightAmount = ThreadLocalRandom.current().nextInt(100, 200); 
        for(int i  = 0; i < flightAmount; i++)
        {
            String flightId = generateRandomString(6);
            String destination = destinations[ThreadLocalRandom.current().nextInt(destinations.length)];
            String origin = destinations[ThreadLocalRandom.current().nextInt(destinations.length)];
            int seatsAvail = ThreadLocalRandom.current().nextInt(10, 150);
            String departureTime = getRandomTime();
            String arrivalTime = getRandomTime2(departureTime);
            int cost = ThreadLocalRandom.current().nextInt(122, 870);
            String date = makeDate();

            flights.add(new Flight(i, flightId, destination, seatsAvail, departureTime, arrivalTime, origin, cost, date));
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


    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }


        public static String makeDate() 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            // Get today's date
            LocalDate today = LocalDate.now();
            
            // Print the next three days
            Random rand = new Random();
            int randomOffset = rand.nextInt(3);  // Random value between 0 and 2
        
            LocalDate randomDate = today.plusDays(randomOffset);  // Get the date
        
            return randomDate.format(formatter);
        }


        public static void removeFlight(int flightID)
        {

        }
}
