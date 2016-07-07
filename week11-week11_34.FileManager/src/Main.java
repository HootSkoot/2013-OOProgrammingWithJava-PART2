
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }
        
    }
}
