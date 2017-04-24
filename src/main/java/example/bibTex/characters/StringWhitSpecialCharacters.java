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

    

    public StringWhitSpecialCharacters() {
    }

    public String specialCharacters(String texti) {
        String g = "";
        for (int i = 0; i < texti.length(); i++) {
            g += car("" + texti.charAt(i));
        }
        return g;
    }

    private String car(String a) {
        String latexmuoto = a;
        switch (a) {
            case "ò":
                latexmuoto = "\\`{o}";
                break;
            case "ä":
                latexmuoto = "\\\"a";
                break;
            case "Ä":
                latexmuoto = "\\\"A";
                break;
            case "ó":
                latexmuoto = "\\'{o}";
                break;
            case "ô":
                latexmuoto = "\\^{o}";
                break;
            case "ö":
                latexmuoto = "\\\"{o}";
                break;
            case "Ö":
                latexmuoto = "\\\"O";
                break;
            case "ő":
                latexmuoto = "\\H{o}";
                break;
            case "õ":
                latexmuoto = "\\~{o}";
                break;
            case "ç":
                latexmuoto = "\\c{c}";
                break;
            case "ą":
                latexmuoto = "\\k{a}";
                break;
            case "ł":
                latexmuoto = "\\l{}";
                break;
            case "ō":
                latexmuoto = "\\={o}";
                break;
            case "ȯ":
                latexmuoto = "\\.{o}";
                break;
            case "ụ":
                latexmuoto = "\\d{u}";
                break;
            case "å":
                latexmuoto = "\\r{a}";
                break;
            case "Å":
                latexmuoto = "\\AA";
                break;
            case "ŏ":
                latexmuoto = "\\u{o}";
                break;
            case "š":
                latexmuoto = "\\v{s}";
                break;
            case "o͡o":
                latexmuoto = "\\t{oo}";
                break;
            case "ø":
                latexmuoto = "\\o";
                break;
            case "%":
                latexmuoto = "\\%";
                break;
            case "$":
                latexmuoto = "\\$";
                break;
            case "_":
                latexmuoto = "\\_";
                break;
            case ">":
                latexmuoto = "\\textgreater";
                break;
            case "|":
                latexmuoto = "\\textbar";
                break;
            case "–":
                latexmuoto = "\\textendash";
                break;
            case "¡":
                latexmuoto = "\\textexclamdown";
                break;
            case "¶":
                latexmuoto = "\\P";
                break;
            case "‡":
                latexmuoto = "\\ddag";
                break;
            case "™":
                latexmuoto = "\\texttrademark";
                break;
            case "£":
                latexmuoto = "\\pounds";
                break;
            case "#":
                latexmuoto = "\\#";
                break;
            case "&":
                latexmuoto = "\\&";
                break;
            case "{":
                latexmuoto = "\\{";
                break;
            case "}":
                latexmuoto = "\\}";
                break;
            case "§":
                latexmuoto = "\\S";
                break;
            case "†":
                latexmuoto = "\\dag";
                break;
            case "\\":
                latexmuoto = "\\textbackslash";
                break;
            case "<":
                latexmuoto = "\\textless";
                break;
            case "—":
                latexmuoto = "\\textemdash";
                break;
            case "®":
                latexmuoto = "\\textregistered";
                break;
            case "¿":
                latexmuoto = "\\textquestiondown";
                break;
            case "ⓐ":
                latexmuoto = "\\textcircled{a}";
                break;
            case "©":
                latexmuoto = "\\copyright";
                break;

        }
        //\textsuperscript{a}
        //k.put("o", "\\b{o}"); en löydä
        return latexmuoto;
    }
}
