package example.bibTex;

import java.util.ArrayList;

/**
 *
 * @author tiera
 */
public class StringReference {
    private String g;

    public StringReference() {
        g = "";
    }
    
    public void greatnewreference(ArrayList<String> k) {
        for (String string : k) {
            newline(string);
        }
        g += "}";
        g += "\n";
        g += "\n";
    }
    
    private void newline(String string) {
        g += string;
        g += "\n";
    }
    
    public String save() {
        return g;
    }
    
}
