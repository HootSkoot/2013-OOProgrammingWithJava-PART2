/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price(){
        return amount * unitPrice;
    }
    
    public void increaseAmount(){
        amount += 1;
    }

    @Override
    public String toString() {
        return product + ": " + amount;
    }
    
    
}
