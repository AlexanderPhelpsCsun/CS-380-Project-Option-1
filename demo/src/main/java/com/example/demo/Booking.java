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
public int gettravelerId(){
    return travelerId;
}
public int getflightId() {
    return flightId;

}
}