/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex.characters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiera
 */
public class StringWithSpecialCharactersTest {

    public StringWithSpecialCharactersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of specialCharacters method, of class StringWhitSpecialCharacters.
     */
    @Test
    public void testSpecialCharacters() {
        System.out.println("specialCharacters");
        String texti = "";
        for (int i = 1; i <= 45; i++) {
            texti += car(i);
        }
        String g = "ò" + "ä" + "Ä" + "ó" + "ô" + "ö" + "Ö" + "ő" + "õ" + "ç" + "ą" + "ł" + "ō" + "ȯ" + "ụ" + "å" + "Å" + "ŏ" + "š" + "ø" + "%" + "$" + "_" + ">" + "|" + "–" + "¡" + "¶" + "‡" + "™" + "£" + "#" + "&" + "{" + "}" + "§" + "†" + "\\" + "<" + "—" + "®" + "¿" + "ⓐ" + "©";
        StringWithSpecialCharacters instance = new StringWithSpecialCharacters();
        String expResult = instance.specialCharacters(g);
        assertEquals(texti, expResult);
    }

    private String car(int a) {
        String latexmuoto = "";
        switch (a) {
            case 1:
                latexmuoto = "\\`{o}";
                break;
            case 2:
                latexmuoto = "\\\"a";
                break;
            case 3:
                latexmuoto = "\\\"A";
                break;
            case 4:
                latexmuoto = "\\'{o}";
                break;
            case 5:
                latexmuoto = "\\^{o}";
                break;
            case 6:
                latexmuoto = "\\\"{o}";
                break;
            case 7:
                latexmuoto = "\\\"O";
                break;
            case 8:
                latexmuoto = "\\H{o}";
                break;
            case 9:
                latexmuoto = "\\~{o}";
                break;
            case 10:
                latexmuoto = "\\c{c}";
                break;
            case 11:
                latexmuoto = "\\k{a}";
                break;
            case 12:
                latexmuoto = "\\l{}";
                break;
            case 13:
                latexmuoto = "\\={o}";
                break;
            case 14:
                latexmuoto = "\\.{o}";
                break;
            case 15:
                latexmuoto = "\\d{u}";
                break;
            case 16:
                latexmuoto = "\\r{a}";
                break;
            case 17:
                latexmuoto = "\\AA";
                break;
            case 18:
                latexmuoto = "\\u{o}";
                break;
            case 19:
                latexmuoto = "\\v{s}";
                break;
            // case 20:
            //   latexmuoto = "\\t{oo}";
            //  break;
            case 21:
                latexmuoto = "\\o";
                break;
            case 22:
                latexmuoto = "\\%";
                break;
            case 23:
                latexmuoto = "\\$";
                break;
            case 24:
                latexmuoto = "\\_";
                break;
            case 25:
                latexmuoto = "\\textgreater";
                break;
            case 26:
                latexmuoto = "\\textbar";
                break;
            case 27:
                latexmuoto = "\\textendash";
                break;
            case 28:
                latexmuoto = "\\textexclamdown";
                break;
            case 29:
                latexmuoto = "\\P";
                break;
            case 30:
                latexmuoto = "\\ddag";
                break;
            case 31:
                latexmuoto = "\\texttrademark";
                break;
            case 32:
                latexmuoto = "\\pounds";
                break;
            case 33:
                latexmuoto = "\\#";
                break;
            case 34:
                latexmuoto = "\\&";
                break;
            case 35:
                latexmuoto = "\\{";
                break;
            case 36:
                latexmuoto = "\\}";
                break;
            case 37:
                latexmuoto = "\\S";
                break;
            case 38:
                latexmuoto = "\\dag";
                break;
            case 39:
                latexmuoto = "\\textbackslash";
                break;
            case 40:
                latexmuoto = "\\textless";
                break;
            case 41:
                latexmuoto = "\\textemdash";
                break;
            case 42:
                latexmuoto = "\\textregistered";
                break;
            case 43:
                latexmuoto = "\\textquestiondown";
                break;
            case 44:
                latexmuoto = "\\textcircled{a}";
                break;
            case 45:
                latexmuoto = "\\copyright";
                break;

        }
        return latexmuoto;
    }

}
