/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import gameoflife.*;
import java.util.Random;

/**
 *
 * @author Michael
 */
public class PersonalBoard extends GameOfLifeBoard{

    public PersonalBoard( int width, int height) {
        super(width, height);
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if ( ( i >= 0 && i < getWidth()) && ( i1 >= 0 && i1 < getHeight())) {
            getBoard()[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        if ( ( i >= 0 && i < getWidth()) && ( i1 >= 0 && i1 < getHeight())) {
            getBoard()[i][i1] = false;
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if ( ( i >= 0 && i < getWidth()) && ( i1 >= 0 && i1 < getHeight())) {
            return getBoard()[i][i1];
        }
        return false;
    }

    @Override
    public void initiateRandomCells(double d) {
        Random random = new Random();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if ( random.nextDouble() < d) {
                    getBoard()[i][j] = true;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int livingNeighboor = 0;
        //checking range
        for (int j = i - 1 ; j <= i + 1; j++) {
            for (int k = i1 - 1; k <= i1 + 1; k++) {
                if ( ( j >= 0 && j < getWidth() ) && ( k >= 0 && k < getHeight()) ) {
                    if (getBoard()[j][k] == true) {
                        livingNeighboor++;
                    }
                }
            }
        }
        if (getBoard()[i][i1] == true) {
            livingNeighboor--;
        }
        return livingNeighboor;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighboor) {
        if ( livingNeighboor < 2) {
            turnToDead(x, y);
        } else if ( isAlive(x, y) && ( livingNeighboor == 2 || livingNeighboor == 3)) {
            
        } else if ( livingNeighboor > 3) {
            turnToDead(x, y);
        } else if ( livingNeighboor == 3) {
            turnToLiving(x, y);
        }
    }
    
}
