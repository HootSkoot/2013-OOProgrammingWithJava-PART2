
import java.util.ArrayList;
import java.util.HashMap;
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
public class OperationAdding {
    private ArrayList<Plane> planesList;
    private ArrayList<Flight> flightList;
    private OperationPrint printing;
    private Scanner reader;

    public OperationAdding( Scanner reader) {
        this.planesList = new ArrayList<Plane>();
        this.flightList = new ArrayList<Flight>();
        this.printing = new OperationPrint(planesList, flightList, reader);
        this.reader = reader;
    }
    
    public void addingFlightsAndRoutes(){
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
        while (true) {            
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String choice = reader.nextLine();
            if (choice.equals("1")) {
                addPlane();
            } else if (choice.equals("2")) {
                addFlight();
            } else if (choice.equals("x")){
                System.out.println("");
                printing.printingPlanesAndFlights();
                break;
            }
        }
    }
    
    public void addPlane(){
        System.out.println("Give plane ID: ");
        String name = reader.nextLine();
        System.out.println("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        planesList.add(new Plane(name, capacity));
    }
    
    public void addFlight(){
        System.out.println("Give plane ID: ");
        String name = reader.nextLine();
        System.out.println("Give departure airport code: ");
        String depart = reader.nextLine();
        System.out.println("Give destination airport code: ");
        String arrive = reader.nextLine();
        for (Plane plane : planesList) {
            if (plane.getName().contains(name)) {
                flightList.add(new Flight(plane, depart, arrive));
            }
        }
    }

    public ArrayList<Plane> getPlanesList() {
        return planesList;
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }
    
}
