
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class RingingCentre {
    private Map<Bird, List<String>> ringingCenter;

    public RingingCentre() {
        ringingCenter = new HashMap<Bird, List<String>>();
    }
    
    public void observe( Bird bird, String place){
        if ( !ringingCenter.containsKey(bird)) {
            ringingCenter.put(bird, new ArrayList<String>());
        }
        ringingCenter.get(bird).add(place);
    }
    
    public void observations(Bird bird){
        System.out.print(bird);
        System.out.print(" observations: ");
        if ( ringingCenter.get(bird) == null) {
            System.out.println("0");
        } else {
            System.out.println(ringingCenter.get(bird).size());
            for (String place : ringingCenter.get(bird)) {
                System.out.println(place);
            }
        }
    }
}
