/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Michael
 */
public class Thermometer implements Sensor{
    private boolean switcher = false;

    @Override
    public boolean isOn() {
        return switcher;
    }

    @Override
    public void on() {
        switcher = true;
    }

    @Override
    public void off() {
        switcher = false;
    }

    @Override
    public int measure() {
        if ( !isOn() ) {
            throw new IllegalStateException();
        }
        Random random = new Random();
        int temp = random.nextInt( 60 ) - 30;
        return temp;
    }
    
}
