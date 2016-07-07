/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Michael
 */
public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.robot = null;
    }

    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        robot = milkingRobot;
        robot.setBulkTank(tank);
    }
    public void takeCareOf(Cow cow){
        try {
            robot.milk(cow);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
    
    public void takeCareOf(Collection<Cow> cows){
        try {
            for (Cow cow : cows) {
                robot.milk(cow);
            }
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return tank.toString();
    }
    
    
}
