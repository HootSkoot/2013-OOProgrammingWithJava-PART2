/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Michael
 */
public class MovingObject {
    public int xPos;
    public int yPos;
    public int xLimit;
    public int yLimit;

    public MovingObject(int xPos, int yPos, int xLimit, int yLimit) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public void move(String playerChoice){
        if ( playerChoice.equals("w")) {
            if ( yPos -1 >= 0) {
                yPos--;
            }
        } else if ( playerChoice.equals("s")) {
            if ( yPos + 1 < yLimit) {
                yPos++;
            }
        } else if ( playerChoice.equals("a")) {
            if ( xPos - 1 >= 0) {
                xPos--;
            }
        } else if ( playerChoice.equals("d")) {
            if (xPos + 1 < xLimit) {
                xPos++;
            }
        }
    }
    
    public boolean doTheyOccupyTheSameSpot( int x, int y){
        return ((getxPos() == x) && (getyPos() == y));
    }

    @Override
    public String toString() {
        return xPos + " " + yPos;
    }

}
