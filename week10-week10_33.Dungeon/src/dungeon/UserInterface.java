/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class UserInterface {
    private Scanner reader = new Scanner(System.in);
    
    public void printDescriptiveHUD(int moves, Player player, List<Vampire> vampires){
        System.out.println(moves);
        System.out.println("");
        System.out.println(player);
        for (Vampire vampire : vampires) {
             System.out.println(vampire);
        }
        System.out.println("");
    }
    
    public void printMap( Player player, List<Vampire> vampires, int length, int height ){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                String atThisPoint = ".";
                for (Vampire vampire : vampires) {
                    if ( vampire.doTheyOccupyTheSameSpot(j, i)) {
                        atThisPoint = "v";
                    }
                }
                if ( player.doTheyOccupyTheSameSpot(j, i) ) {
                  atThisPoint= "@";  
                }
                System.out.print(atThisPoint);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public String takeCommand(){
        return reader.nextLine();
    }
}