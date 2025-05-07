package com.example.demo;
import java.util.ArrayList;


public class Manager {
 
    
    public int showRevenue(ArrayList<Flight> list)
    {
        int retval = 0;
        for(int i  = 0; i < list.size(); i++)
        {
            Flight cur = list.get(i);
            retval += ((150-cur.getSeatsAvail())*cur.getCost());
        }
        return retval;
    }

    public void changeCost(ArrayList<Flight> list, int pflightID, int newCost)
    {
        list.get(pflightID).setCost(newCost);
    }



}
