package example.bibTex;

import java.util.ArrayList;

/**
 * @author tiera
 */
public class ReferenceToRightFormat {

    private ArrayList<String> toWrite;

    public ReferenceToRightFormat() {
    }

    public void Entry(String key, String name) {
        toWrite = new ArrayList<>();
        toWrite.add("@" + key + "{" + name + ",");
    }

    public void oneKeyField(String key, String contents) {
        toWrite.add(key + " = {" + contents + "},");
    }

    public ArrayList<String> referense() {
        return toWrite;
    }

}
