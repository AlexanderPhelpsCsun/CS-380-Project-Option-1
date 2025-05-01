package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    void testGetId() {
        Booking booking = new Booking(1, 101, 1001);
        assertEquals(1, booking.getId());
    }

    @Test
    void testGetTravelerId() {
        Booking booking = new Booking(1, 101, 1001);
        assertEquals(101, booking.getTravelerId());
    }

    @Test
    void testGetFlightId() {
        Booking booking = new Booking(1, 101, 1001);
        assertEquals(1001, booking.getFlightId());
    }
}