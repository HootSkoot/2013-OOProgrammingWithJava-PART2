
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Dictionary {
    private HashMap<String, String> dictionary = new HashMap<String, String>();
    
    public String translate(String word){
        return dictionary.get(word);
    }
    
    public void add(String word, String translation){
        dictionary.put(word, translation);
    }
    
    public int amountOfWords(){
        return dictionary.size();
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> key = new ArrayList<String>(dictionary.keySet());
        ArrayList<String> value = new ArrayList<String>(dictionary.values());
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < dictionary.size(); i++) {
            list.add(key.get(i) + " = " + value.get(i));
        }
        return list;
    } 
}
