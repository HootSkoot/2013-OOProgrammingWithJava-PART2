/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Farm implements Alive{
    private String owner;
    private List<Cow> herd;
    private Barn barn;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        herd = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }
    
    
    
    public void addCow(Cow cow){
        herd.add(cow);
    }
    
    public void installMilkingRobot( MilkingRobot robot){
        barn.installMilkingRobot(robot);
    }
    
    public void manageCows(){
        barn.takeCareOf(herd);
    }

    @Override
    public void liveHour() {
        for (Cow cow : herd) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        String farmInfo = "";
        farmInfo += "Farm owner: " + owner + "\n" + "Barn bulk tank: " + barn.getBulkTank() + "\n"
                + "Animals:";
        for (Cow cow : herd) {
            farmInfo += "        " + cow;
        }
        return farmInfo;
    }
    
    
}
