
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Skier implements Comparable<Skier>{
    private String name;
    private int totalPoints;

    public Skier(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
    
    
    
    public void gettingTotalPoints(Jump jump){
        totalPoints += jump.jumpDistance();
        Collections.sort(jump.setOfJudges());
        for (int i = 1; i < jump.setOfJudges().size() - 1; i++) {
            totalPoints += jump.setOfJudges().get(i);
        }
    }

    @Override
    public int compareTo(Skier otherSkier) {
        return totalPoints - otherSkier.getTotalPoints();
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null) {
            return false;
        }
        if( getClass() != obj.getClass()){
            return false;
        }
        Skier object = (Skier) obj;
        
        if (!name.equals(object.getName())) {
            return false;
        }
        if ( totalPoints != object.getTotalPoints()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " (" + totalPoints + " points)"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
