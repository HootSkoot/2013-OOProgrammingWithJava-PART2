/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Calculator {
    private int input;

    public Calculator() {
        this.input = 0;
    }
    
    public void setInput( int fieldInput){
        input = fieldInput;
    }
    
    public int add( int newInput){
        input += newInput;
        return input;
    }
    
    public int subtract( int newInput){
        input -= newInput;
        return input;
    }
    
}
