/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
