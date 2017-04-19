/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

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
public class ReferenceToStringTest {
    
    private ReferenceToString instance;
    
    public ReferenceToStringTest() {
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
     * Test of HederAndItsType method, of class ReferenceToString.
     */
  

    /**
     * Test of EndFile method, of class ReferenceToString.
     */
    @Test
    public void testEndFile() {
        System.out.println("EndFile");
        String heder = "VPL11";
        String type = "inproceedings";
        instance.HederAndItsType(heder, type);
        instance.OneFieldAndItsType("Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti", "author");
        instance.EndReference();
        String s = instance.EndFile();
        String d = "";
        d += "@inproceedings{VPL11, \n";
        d += "author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti}, \n";
        d += "} \n";
        d += "\n";
        d += "\n";
        assertEquals(d, s);
    }
    
}
