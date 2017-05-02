/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex.characters;

import java.util.HashMap;

/**
 *
 * @author tiera
 */
public class StringWhitSpecialCharacters {
    private HashMap<String, String> spesialCharacters;
        

    public StringWhitSpecialCharacters() {
        spesialCharacters = new HashMap<>();
        spesialCharacters.put("ä", "\\\"a");
        spesialCharacters.put("Ä", "\\\"A");
        spesialCharacters.put("ö", "\\\"{o}");
        spesialCharacters.put("Ö", "\\\"O");
        spesialCharacters.put("å", "\\r{a}");
        spesialCharacters.put("Å", "\\AA");
    }

    public String specialCharacters(String texti) {
        String g = "";
        for (int i = 0; i < texti.length(); i++) {
            g += car("" + texti.charAt(i));
        }
        return g;
    }

    private String car(String a) {
        if (spesialCharacters.containsKey(a)) {
            return spesialCharacters.get(a);
        }
        return a;
    }
}
