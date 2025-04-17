import java.util.ArrayList;

/**
 * Airport class represents the airports that you can book flights to and from.
 * Airport objects keep a list of aircraft that are present at the airport.
 * 
 * @author Alexander
 * @version 1.0
 */
public class Airport {
    String location;
    ArrayList<Aircraft> presentAircrafts = new ArrayList<>();

    public Airport(String location) {
        this.location = location; // <- fixed assignment
    }

    /**
     * Adds an aircraft to the present aircrafts list.
     *
     * @param aircraft the Aircraft object to add
     */
    public void addAircraft(Aircraft aircraft) {
        presentAircrafts.add(aircraft);
    }

    /**
     * Removes an aircraft from the present aircrafts list.
     *
     * @param aircraft the Aircraft object to remove
     */
    public void removeAircraft(Aircraft aircraft) {
        presentAircrafts.remove(aircraft);
    }
}
