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
    *@param String origin where the flight is departing from
    *@param String destination where the flight is landing
    *@param double price is the price for one ticket on the flight
    *@param isFull boolean that returns whether or not the flight has availability
    *return Flight object
    */
    
    public Flight(String origin, String destination, double price, boolean isFull)
    {
        origin = origin;
        destination = destination;
        price = price;
        isFull = isFull;
    }

    /**
    *getAvailability returns a boolean with whether or not the flight is full
    *
    *@return boolean true if flight has vacancy returns false if flight is full
    */
    boolean getAvailability()
    {
        return !isFull;
    }
    /**
    *getPrice is to check the price of a flight
    *
    *@return double with the price
    */
    double getPrice()
    {
        return price;
    } 

    /**
    *getDestination is to access where the flight is going to
    *
    *@return String of Destination
    */
    String getDestination()
    {
        return destination;
    }

    /**
    *getOrigin is to get where the flight is departing from
    *
    *@return String of origin
    */
    String getOrigin()
    {
        return origin;
    }

}
