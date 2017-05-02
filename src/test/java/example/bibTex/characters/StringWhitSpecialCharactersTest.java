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
public class StringWhitSpecialCharactersTest {

    public StringWhitSpecialCharactersTest() {
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
        String texti = "ä";
        String g = "\\\"a";
        StringWhitSpecialCharacters instance = new StringWhitSpecialCharacters();
        String expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
        texti = "Ä";
        g = "\\\"A";
        instance = new StringWhitSpecialCharacters();
        expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
        texti = "ö";
        g = "\\\"{o}";
        instance = new StringWhitSpecialCharacters();
        expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
        texti = "Ö";
        g = "\\\"O";
        instance = new StringWhitSpecialCharacters();
        expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
        texti = "å";
        g = "\\r{a}";
        instance = new StringWhitSpecialCharacters();
        expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
        texti = "Å";
        g = "\\AA";
        instance = new StringWhitSpecialCharacters();
        expResult = instance.specialCharacters(texti);
        assertEquals(g, expResult);
    }

   

}
