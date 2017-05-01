package example.bibTex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tiera
 */
public class WriteReference {

    private FileWriter fw;
    
    public WriteReference(FileWriter filewriter) {
        fw = filewriter;
    }
    
    public void greatnewreference(ArrayList<String> k) throws IOException {
        for (String string : k) {
            newline(string);
        }
        fw.write("}");
        fw.write("\n");
        fw.write("\n");
    }
    
    private void newline(String string) throws IOException {
        fw.write(string);
        fw.write("\n");
    }
    
    public void save() throws IOException{
        fw.close();
    }
}