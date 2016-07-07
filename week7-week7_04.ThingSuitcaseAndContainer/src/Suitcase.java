
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Suitcase {
    private int weightLimit;
    private ArrayList<Thing> things; 

    public Suitcase(int weightLimit) {
        this.weightLimit = weightLimit;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing){
        if ( thing.getWeight() + totalWeight() <= weightLimit) {
            things.add(thing);
        }
    }
        
    public int totalWeight(){
        int suitcaseWeight = 0;
        for (Thing pieces : things) {
            suitcaseWeight += pieces.getWeight();
        }
        return suitcaseWeight;
    }

    @Override
    public String toString() {
        if ( things.size() == 0) {
            return "empty (0 kg)";
        } else if ( things.size() == 1) {
            return "1 thing (" + totalWeight() + " kg)";
        } else {
            return things.size() + " things (" + totalWeight() + "kg)";
        }
    }
    
    public void printThings(){
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }
    
    public Thing heaviestThing(){
        int comparison = 0;
        Thing heaviest = null;
        for (Thing thing : things) {
            if ( thing.getWeight() >= comparison) {
                comparison = thing.getWeight();
                heaviest = thing;
            }
        }
        return heaviest;
    }
}
