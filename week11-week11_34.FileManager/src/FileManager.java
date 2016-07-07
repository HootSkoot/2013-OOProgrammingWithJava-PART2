
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        List<String> fileRead = new ArrayList<String>();
        File fileNew = new File(file);
        Scanner reader = new Scanner(fileNew);
        while ( reader.hasNextLine()) {            
            fileRead.add(reader.nextLine());
        }
        return fileRead;
        
    }

    public void save(String file, String text) throws IOException {
        FileWriter fileNew = new FileWriter(file);
        fileNew.write(text);
        fileNew.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fileNew = new FileWriter(file);
        for (String text : texts) {
            fileNew.write(text + "\n");
        }
        fileNew.close();
    }
}
