/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Box implements Thing{
    private int maximumCapacity;
    private ArrayList<Thing> thingsInBox;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        thingsInBox = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing){
        if ( getVolume() + thing.getVolume() > maximumCapacity) {
            return false;
        }
        thingsInBox.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing item : thingsInBox) {
            totalVolume += item.getVolume();
        }
        return totalVolume;
    }
    
    
}
