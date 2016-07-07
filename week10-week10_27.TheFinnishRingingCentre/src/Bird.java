
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    public boolean equals(Object obj) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass()) {
            return false;
        }
        Bird otherBird = (Bird) obj;
        
        return ( latinName.equals(otherBird.latinName)) && (ringingYear == otherBird.ringingYear);
    }

    @Override
    public int hashCode() {
        if ( latinName == null) {
            return 7;
        }
        return latinName.hashCode() + ringingYear;
    }
    
    
}


