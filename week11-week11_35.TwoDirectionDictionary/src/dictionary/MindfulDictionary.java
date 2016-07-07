/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class MindfulDictionary {
    
    private Map<String, String> engToFin = new HashMap<String, String>();
    private Map<String, String> finToEng = new HashMap<String, String>();
    private String file;

    public MindfulDictionary() {
    }
    
    public MindfulDictionary( String file){
        this.file = file;
    }
    public String translate( String word){
        if ( engToFin.containsKey(word)) {
            return engToFin.get(word);
        } else if ( finToEng.containsKey(word)) {
            return finToEng.get(word);
        } else {
            return null;
        }
    }
    
    public boolean load(){
        try {
            File fileNew = new File(file);
            Scanner fileReader = new Scanner(fileNew);
            while ( fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] fileSplit = line.split(":");
                this.add(fileSplit[0], fileSplit[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public void add( String word, String translation){
        if ( !engToFin.containsKey(word)) {
            engToFin.put(word, translation);
        }  if( !finToEng.containsKey(translation)) {
            finToEng.put(translation, word);
        }
    }
    
    public void remove(String word){
        String trans1 = engToFin.get(word);
        String trans2 = finToEng.get(word);
        engToFin.remove(word);
        engToFin.remove(trans1);
        engToFin.remove(trans2);
        finToEng.remove(word);
        finToEng.remove(trans1);
        finToEng.remove(trans2);
    }
    
    public boolean save(){
        try {
            FileWriter fileWrite = new FileWriter(file);
            for (String entry : engToFin.keySet()) {
                fileWrite.write(entry + ":" + engToFin.get(entry));
                fileWrite.write("\n");
            }
            fileWrite.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
