
import java.util.Scanner;


public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");
        
        Scanner reader = new Scanner(System.in);
        String smiley = reader.nextLine();
        
        printWithSmileys(smiley);
        
    }
    
    private static String printReaderLine( String input ){
        if ( input.length()%2 != 0 ) {
            return ":) " + input + "  :)";
        } else{
            return ":) " + input + " :)";
        }
    } 
    private static void printWithSmileys(String characterString){
        String smileyLine = "";
        for (int i = 0; i < printReaderLine(characterString).length(); i++) {
            if ( i%2 == 0) {
                smileyLine += ":)";
            }
        }
        System.out.println(smileyLine);
        System.out.println(printReaderLine(characterString));
        System.out.println(smileyLine);
    }

}
