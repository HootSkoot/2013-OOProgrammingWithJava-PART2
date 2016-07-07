/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class WordInspection {
    private File file;

    public WordInspection(File file) {
        this.file = file;
    }
    
    private List<String> readFile(){
        List<String> words = new ArrayList<String>();
        try {
            Scanner reader = new Scanner(file, "UTF-8");
            String line = "";
            while (reader.hasNext()) {                
                line = reader.next();
                words.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File cant be read.  Error: " + e.getMessage());
        }
        return words;
    }
    
    public int wordCount(){
        return readFile().size();
    }
    
    public List<String> wordsContainingZ(){
        List<String> words = new ArrayList<String>();
        for (String word : readFile()) {
            if (word.toLowerCase().contains("z")) {
                words.add(word);
            }
        }
        return words;
    }
    public List<String> wordsEndingInL(){
        List<String> words = new ArrayList<String>();
        for (String word : readFile()) {
            if (word.endsWith("l") ) {
                words.add(word);
            }
        }
        return words;
    }
    public List<String> palindromes(){
        List<String> words = new ArrayList<String>();
        String normalWord;
        String reverseWord;
        for (String word : readFile()) {
            reverseWord = "";
            for (int i = word.length() - 1; i >= 0 ; i--) {
                reverseWord += word.charAt(i);
            }
            if ( word.equals(reverseWord)) {
                words.add(word);
            }
        }
        return words;
    }
    public List<String> wordsWhichContainAllVowels(){
        List<String> words = new ArrayList<String>();
        for (String word : readFile()) {
            if ( word.contains("a") &&  word.contains("e") &&  word.contains("i") &&  word.contains("o") &&  word.contains("u") &&  word.contains("y") &&  word.contains("ä") &&  word.contains("ö")) {
                words.add(word);
            }
        }
        return words;
    }
}
