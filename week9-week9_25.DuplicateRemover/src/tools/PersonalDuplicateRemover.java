/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michael
 */
public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> words;
    private int numDuplicates;

    public PersonalDuplicateRemover() {
        words = new HashSet<String>();
        numDuplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        if ( words.contains(characterString)) {
            numDuplicates++;
            return;
        }
        words.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
    }

    @Override
    public void empty() {
        words.removeAll(words);
        numDuplicates = 0;
    }
    
}
