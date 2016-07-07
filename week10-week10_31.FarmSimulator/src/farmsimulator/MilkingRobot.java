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
public class MilkingRobot {
    private BulkTank tank;

    public MilkingRobot() {
        tank = null;
    }
    
    public BulkTank getBulkTank(){
        return tank;
    }
    public void setBulkTank( BulkTank bulktank){
        tank = bulktank;
    }
    public void milk(Milkable milkable){
        try {
            tank.addToTank(milkable.milk());
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
