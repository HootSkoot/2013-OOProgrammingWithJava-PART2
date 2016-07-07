/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Analysis {
    private File file;
    private Scanner reader;

    public Analysis(File file) throws Exception{
        this.file = file;
    }
    public int lines() throws FileNotFoundException{
        int count = 0;
        try {
            reader = new Scanner(file);
            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                count++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File can not be read.  Error: " + e.getMessage());
        }
        return count;
    }
    
    public int characters(){
        int count = 0;
        try {
            reader = new Scanner(file);
            reader.useDelimiter("");
            String line;
            while (reader.hasNext()) {
                line = reader.next();
                count++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File can not be read.  Error: " + e.getMessage());
        }
        return count;
    }
}
