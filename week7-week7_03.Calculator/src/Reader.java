
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Reader {
    private Scanner input = new Scanner(System.in);
    
    public String readString(){
        return input.nextLine();
    }
    
    public int readInteger(){
        return Integer.parseInt(input.nextLine());
    }
}
