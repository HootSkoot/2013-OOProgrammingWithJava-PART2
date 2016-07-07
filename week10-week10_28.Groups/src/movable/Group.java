/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Group implements Movable{
    
    private List<Movable> organisms;

    public Group() {
        organisms = new ArrayList<Movable>();
    }
    
    public void addToGroup( Movable movable){
        if ( !organisms.contains(movable)) {
            organisms.add(movable);
        }
    }

    @Override
    public String toString() {
        String groupString = "";
        for (Movable organism : organisms) {
            groupString += organism;
            groupString += "\n";
        }
        return groupString;
    }
    
    

    @Override
    public void move(int dx, int dy) {
        for (Movable organism : organisms) {
            organism.move(dx, dy);
        }
    }
    
}
