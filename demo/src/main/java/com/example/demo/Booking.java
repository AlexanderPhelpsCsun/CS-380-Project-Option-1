package com.example.demo;


public class Booking {
    private int id;
    private int travelerId;
    private int flightId;

public Booking(int id, int travelerId, int flightId){
    this.id = id;
    this.travelerId = travelerId;
    this.flightId = flightId;
}
public int getId(){
    return id;
}
public int getTravelerId(){
    return travelerId;
}
public int getFlightId() {
    return flightId;

}
}