/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tiera
 */
public class ReferenceToRightFormat {

    private ArrayList<String> toWrite;
    
    public ReferenceToRightFormat() {
     /*   k = new ArrayList<>();
        
        k.add("type");
        k.add("name");

        k.add("address");
        k.add("annote");
        k.add("author");

        k.add("booktitle");
        k.add("chapter");
        k.add("crossref");

        k.add("edition");
        k.add("editor");
        k.add("howpublished");

        k.add("institution");
        k.add("journal");
        k.add("key");

        k.add("month");
        k.add("note");
        k.add("number");

        k.add("organization");
        k.add("pages");
        k.add("publisher");

        k.add("school");
        k.add("series");
        k.add("title");

        k.add("type");
        k.add("volume");
        k.add("volume");
*/
    }
    
    
    public void Entry(String key, String name){
        toWrite = new ArrayList<>();
        toWrite.add("@" + key + "{" + name + ",");
        
    }

    public void oneKeyField(String key, String contents) {
        toWrite.add(key + " = {"+ contents+ "},");
    }
    
    public ArrayList<String> referense(){
        return toWrite;
    }

}
