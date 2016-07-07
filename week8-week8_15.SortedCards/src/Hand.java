
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card){
        hand.add(card);
    }
    
    public void print(){
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    public void sort(){
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand handOpp) {
        int total = 0;
        int oppTotal = 0;
        for (Card card1 : hand) {
            total += card1.getValue();
        }
        for (Card cardOpp : handOpp.hand) {
            oppTotal += cardOpp.getValue();
        }
        return total - oppTotal;
    }
    
    public void sortAgainstSuit(){
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
