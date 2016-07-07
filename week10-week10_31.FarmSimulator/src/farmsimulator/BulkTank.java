/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Michael
 */
public class BulkTank {
    private double capacity;
    private double volume;

    public BulkTank() {
        capacity = 2000.0;
        volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        volume = 0;
    }
    
    public double getCapacity(){
        return capacity;
    }

    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace(){
        return capacity - volume;
    }
    public void addToTank( double amount){
        if ( amount + volume > capacity) {
            volume = capacity;
        } else {
            volume += amount;
        }
    }
    public double getFromTank( double amount){
        if ( volume - amount < 0) {
            double takenAmount = volume;
            volume = 0;
            return takenAmount;
        } else {
            volume -= amount;
            return amount;
        }
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
    
}
