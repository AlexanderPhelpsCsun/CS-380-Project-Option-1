import java.util.ArrayList;

public class Airport {
    String location;
    ArrayList<aircraft> presentAircrafts = new ArrayList<>();



    void addFlight(Flight flight)
    {
        presentAircrafts.add(flight);
    }
    void removeFlight(Flight flight)
    {
        presentAircrafts.remove(flight);
    }
}
