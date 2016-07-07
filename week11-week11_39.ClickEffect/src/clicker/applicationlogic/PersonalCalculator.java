/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author Michael
 */
public class PersonalCalculator implements Calculator{
    private int total;

    public PersonalCalculator() {
        total = 0;
    }

    @Override
    public int giveValue() {
        return total;
    }

    @Override
    public void increase() {
        total++;
    }
    
}
