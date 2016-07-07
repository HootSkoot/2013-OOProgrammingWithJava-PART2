
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
public class Box implements ToBeStored{
    private ArrayList<ToBeStored> boxContainer;
    private double weightLimit;

    public Box( double weightLimit) {
        boxContainer = new ArrayList<ToBeStored>();
        this.weightLimit = weightLimit;
    }
    
    public void add(ToBeStored item){
        if ( weight() + item.weight() <= weightLimit) {
            boxContainer.add(item);
        }
    }
    
    public double weight(){
        double weight = 0;
        for (ToBeStored item : boxContainer) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + boxContainer.size() + " things, total weight " + weight() + " kg";
    }
    
    
}
