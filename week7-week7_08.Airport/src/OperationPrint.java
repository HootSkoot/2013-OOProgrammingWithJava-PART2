
import java.util.ArrayList;
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
public class OperationPrint {
    private ArrayList<Plane> planeList;
    private ArrayList<Flight> flightList;
    private Scanner reader;

    public OperationPrint(ArrayList<Plane> planeList, ArrayList<Flight> flightList, Scanner reader) {
        this.planeList = planeList;
        this.flightList = flightList;
        this.reader = reader;
    }
    
    public void printingPlanesAndFlights(){
        System.out.println("Flight service");
        System.out.println("--------------------");
        System.out.println();
        while (true) {            
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String choice = reader.nextLine();
            if ( choice.equals("1")) {
                printPlanes();
                System.out.println("");
            } else if ( choice.equals("2")) {
                printFlights();
                System.out.println("");
            } else if ( choice.equals("3")){
                printSinglePlane();
                System.out.println("");
            } else if ( choice.equals("x")) {
                break;
            }
        }
    }
    public void printPlanes(){
        for (Plane plane : planeList) {
            System.out.println(plane);
        }
    }
    public void printFlights(){
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
    public void printSinglePlane(){
        System.out.println("Give plane ID: ");
        String id = reader.nextLine();
        for (Plane plane : planeList) {
            if (plane.getName().contains(id)) {
                System.out.println(plane);
            }
        }
    }
}
