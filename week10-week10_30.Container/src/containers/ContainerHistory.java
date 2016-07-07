/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ContainerHistory {
    private List<Double> containerHistory;

    public ContainerHistory() {
        containerHistory = new ArrayList<Double>();
    }
    
    public void add( double situation){
        containerHistory.add(situation);
    }
    
    public void reset(){
        containerHistory.clear();
    }

    @Override
    public String toString() {
        return containerHistory.toString();
    }
    
    public double maxValue(){
        if ( containerHistory.isEmpty()) {
            return 0;
        } else {
            return Collections.max(containerHistory);
        }
    }
    public double minValue(){
        if ( containerHistory.isEmpty()) {
            return 0;
        } else {
            return Collections.min(containerHistory);
        }
    }
    public double average(){
        if ( containerHistory.isEmpty()) {
            return 0;
        } else {
            double ave = 0;
            for (Double reading : containerHistory) {
                ave += reading;
            }
            return ave / containerHistory.size();
        }
    }
    
    public double greatestFluctuation(){
        if ( containerHistory.isEmpty() || containerHistory.size() == 1) {
            return 0;
        }
        double greatestFluctuation = 0;
        double fluctuation = 0;
        double firstValue = containerHistory.get(0);
        for (Double entry : containerHistory) {
            fluctuation = Math.abs( firstValue - entry );
            if ( fluctuation > greatestFluctuation ) {
                greatestFluctuation = fluctuation;
            }
            firstValue = entry;
        }
        return greatestFluctuation;
    }
    
    public double variance(){
        if ( containerHistory.isEmpty() || containerHistory.size() == 1) {
            return 0;
        }
        double variance = 0;
        for (Double entry : containerHistory) {
            variance += Math.pow( entry - average(), 2);
        }
        variance = variance / ( containerHistory.size() - 1);
        return variance;
    }
}
