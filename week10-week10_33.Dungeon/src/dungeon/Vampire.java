/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael
 */
public class Vampire extends MovingObject{
    
    public Vampire(int xPos, int yPos, int xLimit, int yLimit) {
        super(xPos, yPos, xLimit, yLimit);
    }
    
    public void move( List<Vampire> vampires){
        String[] directions = {"w", "a", "s", "d"};
        String chosenDirection = directions[ new Random().nextInt(4)];
        int xBeforeMovement = getxPos();
        int yBeforeMovement = getyPos();
        super.move(chosenDirection);
        int vampiresInGivenPosition = 0;
        for (Vampire otherVampire : vampires) {
            if ( (getxPos() == otherVampire.getxPos()) && (getyPos() == otherVampire.getyPos())) {
                vampiresInGivenPosition++;
            }
        }
        if ( vampiresInGivenPosition > 1) {
            setxPos(xBeforeMovement);
            setyPos(yBeforeMovement);
        }
    }

    @Override
    public String toString() {
        return "v " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
