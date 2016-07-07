/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Flight {
    private Plane plane;
    private String departureCode;
    private String destinationCode;

    public Flight(Plane plane, String departureCode, String destinationCode) {
        this.plane = plane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    @Override
    public String toString() {
        return plane.toString() + " (" + departureCode + "-" + destinationCode + ")"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
