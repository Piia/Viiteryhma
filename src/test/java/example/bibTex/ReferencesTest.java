/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
public class ReferencesTest {

    private References instance;
    private File l;

    public ReferencesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException {
        l = new File("test.bib");
        instance = new References(l);
    }

    @After
    public void tearDown() throws IOException {
        l = new File("test.bib");
        instance = new References(l);
    }

    /**
     * Test of HederAndItsType method, of class References.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testHederAndItsType() throws IOException {
        System.out.println("HederAndItsType");
        String heder = "VPL11";
        String type = "inproceedings";
        instance.HederAndItsType(heder, type);
        instance.OneFieldAndItsType("Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti", "author");
        instance.EndReference();
        instance.EndFile();
        Scanner lukija = new Scanner(l);
        String g = lukija.nextLine();
        assertEquals("@inproceedings{VPL11,", g);
        g = lukija.nextLine();
        assertEquals("author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},", g);
        g = lukija.nextLine();
        assertEquals("}", g);
    }

}
