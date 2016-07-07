
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
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start(){
        System.out.println("Statement:");
        System.out.println("  quit - quit the text user interface");
        while (true) {            
            System.out.println("Statement:");
            String selection = reader.nextLine();
            if ( selection.equals("add")) {
                System.out.println("In Finnish: ");
                String finnish = reader.nextLine();
                System.out.println("Translation: ");
                String translation = reader.nextLine();
                dictionary.add(finnish, translation);
            } else if ( selection.equals("translate")) {
                System.out.println("Give a word: ");
                String finnish = reader.nextLine();
                System.out.println("Translation: " + dictionary.translate(finnish));
            } else if(selection.equals("quit")){
                break;
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
}
