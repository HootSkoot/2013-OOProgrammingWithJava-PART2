/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Michael
 */
public class Cow implements Milkable, Alive{
    private String name;
    private double capacity;
    private double availableMilk;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        name = NAMES[new Random().nextInt(NAMES.length)];
        capacity = 15 + new Random().nextInt(26);
        availableMilk = 0;
    }

    public Cow(String name) {
        this.name = name;
        capacity = 15 + new Random().nextInt(26);
        availableMilk = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public double getCapacity(){
        return capacity;
    }
    
    public double getAmount(){
        return availableMilk;
    }
    
    
    @Override
    public String toString() {
        return name + " " + Math.ceil(availableMilk) + "/" + Math.ceil(capacity);
    }

    @Override
    public void liveHour() {
        availableMilk += (new Random().nextInt(14) + 7.0) / 10.0;
        if ( availableMilk > capacity) {
            availableMilk = capacity;
        }
    }

    @Override
    public double milk() {
        double amountMilked = availableMilk;
        availableMilk = 0;
        return amountMilked;
    }
    
}
