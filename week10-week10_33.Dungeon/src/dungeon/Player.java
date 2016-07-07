/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Player extends MovingObject{
    
    public Player(int xLimit, int yLimit) {
        super(0, 0, xLimit, yLimit);
    }
    
    public void killedAVampire( List<Vampire> vampires){
        List<Vampire> killedVampires = new ArrayList<Vampire>();
        for (Vampire deadVamp : vampires) {
            if ( (getxPos() == deadVamp.getxPos()) && (getyPos() == deadVamp.getyPos())) {
                killedVampires.add(deadVamp);
            }
        }
        vampires.removeAll(killedVampires);
    }

    @Override
    public String toString() {
        return "@ " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
