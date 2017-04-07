/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.util.ArrayList;
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
public class ReferenceToRightFormatTest {
    
    ReferenceToRightFormat instance;
    
    public ReferenceToRightFormatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String key = "inproceedings";
        String name = "VPL11";
        instance = new ReferenceToRightFormat();
        instance.Entry(key, name);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of Entry method, of class ReferenceToRightFormat.
     */
    @Test
    public void testEntry() {
        System.out.println("Entry");
        assertEquals("@inproceedings{VPL11,", instance.referense().get(0));
    }

    /**
     * Test of oneKeyField method, of class ReferenceToRightFormat.
     */
    @Test
    public void testOneKeyField() {
        System.out.println("oneKeyField");
        String key = "author";
        String contents = "Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti";
        instance.oneKeyField(key, contents);
        assertEquals("author = {Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti},", instance.referense().get(1));
    }


    
}
