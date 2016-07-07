
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
public class Container {
    private int weightLimit;
    private ArrayList<Suitcase> containing;

    public Container(int weightLimit) {
        this.weightLimit = weightLimit;
        this.containing = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase){
        int tentativeContainerWeight = suitcase.totalWeight();
        for (Suitcase ownedSuitcase : containing) {
             tentativeContainerWeight += ownedSuitcase.totalWeight();
        }
        if ( tentativeContainerWeight <= weightLimit ) {
            containing.add(suitcase);
        }
    }

    @Override
    public String toString() {
        int totalWeight = 0;
        for (Suitcase suitcase : containing) {
            totalWeight += suitcase.totalWeight();
        }
        return containing.size() + " suitcases (" + totalWeight + " kg)"; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printThings(){
        for (Suitcase suitcase : containing) {
            suitcase.printThings();
        }
    }
}
