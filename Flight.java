public class Flight {
    String origin;
    String destination;
    double price;
    boolean isFull;
    
    public Flight(String origin, String destination, double price, boolean isFull)
    {
        origin = origin;
        destination = destination;
        price = price;
        isFull = isFull;
    }

    boolean getAvailability()
    {
        return isFull;
    }

    double getPrice()
    {
        return price;
    } 

    String getDestination()
    {
        return destination;
    }

    String getOrigin()
    {
        return origin;
    }

}
