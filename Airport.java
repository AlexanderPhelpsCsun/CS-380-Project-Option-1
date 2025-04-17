import java.util.ArrayList;

/**
Airport class represents the airports that you can book flights too and from. Airport objects will keep a List of aircrafts that are present at the airport.
@Author Alexander
@Version 1.0
*/
public class Airport {
    String location;
    ArrayList<Aircraft> presentAircrafts = new ArrayList<>();

/**
Adds an aircraft to the present aircrafts list
@param Aircraft object
@return void
*/
    void addAircraft(Aircraft aircraft)
    {
        presentAircrafts.add(aircraft);
    }
/**
Removes an aircraft from the present aircrafts list
@param Aircraft object
@return void
*/

    void removeAircraft(Aircraft aircraft)
    {
        presentAircrafts.remove(aircraft);
    }
}

