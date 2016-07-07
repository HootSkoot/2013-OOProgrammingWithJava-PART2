
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
    }
    
    public static void addSuitcasesFullOfBricks(Container container){
        for (int i = 1; i < 100; i++) {
            Thing brick = new Thing("brick", i);
            Suitcase brickfull = new Suitcase(i);
            brickfull.addThing(brick);
            container.addSuitcase(brickfull);
            
        }
    }

}
