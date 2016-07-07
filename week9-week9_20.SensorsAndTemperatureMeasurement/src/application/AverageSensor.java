/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class AverageSensor implements Sensor{
    private List<Sensor> sensorCollection;
    private List<Integer> readings; 

    public AverageSensor() {
        sensorCollection = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional){
        sensorCollection.add(additional);
    }

    @Override
    public boolean isOn() {
        boolean checkingStatus = true;
        for (Sensor sensor : sensorCollection) {
            if ( !sensor.isOn() ) {
                checkingStatus = false;
            }
        }
        return checkingStatus;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensorCollection) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensorCollection) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        int average = 0;
        if ( !isOn() || sensorCollection.isEmpty()) {
            throw new IllegalStateException();
        }
 
        for (Sensor sensor : sensorCollection) {
            average += sensor.measure();
        }
        average /= sensorCollection.size();
        readings.add(average);
        return average;
    }
    
    public List<Integer> readings(){
        return readings;
    }
    
}
