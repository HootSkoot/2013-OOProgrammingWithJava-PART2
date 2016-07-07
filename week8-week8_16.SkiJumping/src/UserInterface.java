
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class UserInterface {
    private ArrayList<Skier> competingSkiers;
    private Map<Skier, ArrayList<Jump>> skiersAndThierRounds;

    public UserInterface() {
        competingSkiers = new ArrayList<Skier>();
        skiersAndThierRounds = new HashMap<Skier, ArrayList<Jump>>();
    }
    
    
    
    public void addingName(Scanner reader){
        //loops until name given
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {            
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.equals("")) {
                break;
            }
            //checking to see if name is used
            Boolean nameAlreadyUsed = false;
            for (Skier skier : competingSkiers) {
                if (skier.getName().equals(name)) {
                    nameAlreadyUsed = true;
                }
            }
            if (!nameAlreadyUsed) {
                //adds same skier to both list and hashmap
                Skier skier = new Skier(name);
                competingSkiers.add(skier);
                skiersAndThierRounds.put(skier, new ArrayList<Jump>());
            }
        }
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
    }
    
    public void roundOfJumping(int round){
        //Does not loop, just a single round
        System.out.println("Round " + round);
        System.out.println("");
        System.out.println("Jumping order:");
        //sort before listing skiers
        Collections.sort(competingSkiers);
        for (Skier skier : competingSkiers) {
            int i = 1;
            System.out.println("  " + i++ + ". " + skier);
        }
        System.out.println("");
        System.out.println("Results of round " + round);
        for (Skier skier : competingSkiers) {
            //where an individual jump is assigned to a skier
            System.out.println("  " + skier.getName());
            Jump jump = new Jump();
            jump.jumping();
            //set total points for sorting
            skier.gettingTotalPoints(jump);
            skiersAndThierRounds.get(skier).add(jump);
            System.out.println(jump);
        }
        System.out.println("");
    }
    
    public void tournamentResults(){
        //prints the final results
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(competingSkiers);
        Collections.reverse(competingSkiers);
        //lists skiers
        for (Skier skier : competingSkiers) {
            int i = 1;
            System.out.println( i + "           " + skier);
            System.out.print("            jump lengths: ");
            //loops through individual skiers jumps
            for (int j = 0; j < skiersAndThierRounds.get(skier).size(); j++) {
                //propper comma formatting
                if ( j == skiersAndThierRounds.get(skier).size() - 1) {
                    System.out.print(skiersAndThierRounds.get(skier).get(j).jumpDistance() + "\n");
                } else {
                System.out.print(skiersAndThierRounds.get(skier).get(j).jumpDistance() + ", ");
                }
            }
            i++;
        }
    }
}
