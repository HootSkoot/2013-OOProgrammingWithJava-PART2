
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner reader = new Scanner(System.in);
        UserInterface userInterface = new UserInterface();
        
        System.out.println("Kumpula ski jumping week" + "\n");
        userInterface.addingName(reader);
        int round = 0;
        while (true) {            
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String selection = reader.nextLine();
            System.out.println("");
            if (selection.equals("jump")) {
                round++;
                userInterface.roundOfJumping(round);
            }
            if (selection.equals("quit")) {
                System.out.println("\n" + "Thanks!" + "\n");
                userInterface.tournamentResults();
                break;
            }

        }
    }
}
