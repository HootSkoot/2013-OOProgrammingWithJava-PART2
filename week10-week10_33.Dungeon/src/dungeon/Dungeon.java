/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael
 */
public class Dungeon {
    private int height;
    private int width;
    private int numOfVamps;
    private int moves;
    private boolean vampiresMove;
    private Player player;
    private List<Vampire> vampiresCollected;

    public Dungeon(int width, int height, int numOfVamps, int moves, boolean vampiresMove) {
        this.height = height;
        this.width = width;
        this.numOfVamps = numOfVamps;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player( width, height);
        createVampList(numOfVamps, width, height);
    }
    
    public void run(){
        UserInterface ui = new UserInterface();
        
        String commands;
        while (true) {
            ui.printDescriptiveHUD(moves, player, vampiresCollected);
            ui.printMap(player, vampiresCollected, height, height);
            commands = ui.takeCommand();
            move(commands);
            player.killedAVampire(vampiresCollected);
            if (gameEndState()) {
                break;
            }
        }
    }
    
    public void createVampList( int numOfVamps, int width, int height){
        vampiresCollected = new ArrayList<Vampire>();
        Random random = new Random();
        for (int i = 0; i < numOfVamps; i++) {
            vampiresCollected.add(new Vampire(random.nextInt(width), random.nextInt(height), width, height));
        }
    }
    
    public void move(String commands){
        for (int i = 0; i < commands.length(); i++) {
            player.move(Character.toString(commands.charAt(i)));
            if (vampiresMove) {
                for (Vampire vampire : vampiresCollected) {
                    vampire.move(vampiresCollected);
                }
            }
        }
        moves--;
    }
    
    public boolean gameEndState(){
        if (vampiresCollected.isEmpty()) {
            System.out.println("YOU WIN");
            return true;
        }
        if ( moves <= 0 ) {
            System.out.println("YOU LOSE");
            return true;
        }
        return false;
    }
}
