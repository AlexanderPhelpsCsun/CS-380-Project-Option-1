/**
*Flight class holds the information for each flight that can be booked. It holds information like origin and destination that the flight 
*will be on. It will also hold price and whether or not it is completely booked and full

*@author Alexander
*@version 1.0
*/


public class Flight {
    String origin;
    String destination;
    double price;
    boolean isFull;


    /**
    *The flight constructor makes the flight object and sets origin, destination, price and whether or not it is full
    *
    *@param origin where the flight is departing from
    *@param destination where the flight is landing
    *@param price is the price for one ticket on the flight
    *@param isFull boolean that returns whether or not the flight has availability
    */
    
    public Flight(String origin, String destination, double price, boolean isFull)
    {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.isFull = isFull;
    }

    /**
    *getAvailability returns a boolean with whether or not the flight is full
    *
    *@return true if flight has vacancy returns false if flight is full
    */
    public boolean getAvailability()
    {
        return !this.isFull;
    }
    /**
    *getPrice is to check the price of a flight
    *
    *@return the price
    */
    public double getPrice()
    {
        return this.price;
    } 

    /**
    *getDestination is to access where the flight is going to
    *
    *@return Destination
    */
    public String getDestination()
    {
        return this.destination;
    }

    /**
    *getOrigin is to get where the flight is departing from
    *
    *@return origin
    */
    public String getOrigin()
    {
        return this.origin;
    }

}
