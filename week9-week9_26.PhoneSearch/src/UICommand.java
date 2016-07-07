
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
public class UICommand {
    
    public void start( Scanner reader ){
        UserInterface ui = new UserInterface();
        ui.initilize();
        ui.printMenuChoices();
        loopingCommands( ui, reader );
    }
    
    public void loopingCommands( UserInterface ui, Scanner reader  ){
        String choice = "";
        while (true) {            
            System.out.println("");
            System.out.print("command: ");
            choice = reader.nextLine();
            if ( choice.equals("x")) {
                break;
            }
            if ( choice.equals("1")) {
                ui.addingPhoneToPerson( reader );
            }
            if ( choice.equals("2")) {
                ui.searchPhoneByName(reader);
            }
            if ( choice.equals("3")) {
                ui.searchNameByPhone(reader);
            }
            if ( choice.equals("4")) {
                ui.addingAddress(reader);
            }
            if ( choice.equals("5")) {
                ui.findInfo(reader );
            }
            if ( choice.equals("6")) {
                ui.deletePersonalInformation(reader);
            }
            if ( choice.equals("7")) {
                ui.filteredSearch(reader);
            }
        }
    }
}
