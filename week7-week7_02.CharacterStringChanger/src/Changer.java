
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Changer {
    private ArrayList<Change> changeList;

    public Changer() {
        changeList = new ArrayList<Change>();
    }
    
    public void addChange(Change change){
        changeList.add(change);
    }
    
    public String change(String characterString){
        for (Change changeClass : changeList) {
            characterString = changeClass.change(characterString);
        }
        return characterString;
    }
}
