
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Jump {
    private int jumpDistance;
    private ArrayList<Integer> judgePointsSets;

    public Jump() {
        jumpDistance = 0;
        judgePointsSets = new ArrayList<Integer>();
    }
    
    public void jumping(){
        Random random = new Random();
        jumpDistance = random.nextInt( 120 - 60 + 1 ) + 60;
        for (int i = 0; i < 5; i++) {
            judgePointsSets.add(random.nextInt( 20 - 10 + 1 ) + 10 );
        }
    }
    
    public int jumpDistance(){
        return jumpDistance;
    }
    public ArrayList<Integer> setOfJudges(){
        return judgePointsSets;
    }

    @Override
    public int hashCode() {
        return judgePointsSets.hashCode() + jumpDistance;
    }

    @Override
    public String toString() {
        return "    length: " + jumpDistance + "\n" + 
                "    judge votes: " + judgePointsSets;
    }
    
}
