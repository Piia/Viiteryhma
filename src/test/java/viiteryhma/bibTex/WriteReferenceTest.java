/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viiteryhma.bibTex;

import example.bibTex.WriteReference;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
public class WriteReferenceTest {

    public WriteReferenceTest() {
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
     * Test of greatnewreference method, of class WriteReference.
     */
    @Test
    public void testGreatnewreference() throws Exception {
        File file = new File("test.bib");
        FileWriter filewriter = new FileWriter(file);
        WriteReference o = new WriteReference(filewriter);
        ArrayList<String> k = referense1();
        o.greatnewreference(k);
        o.save();
        Scanner lukija = new Scanner(file);
        k.stream().forEach((string) -> {
            String t = lukija.nextLine();
            assertEquals(string, t);
        });
        
        
    }

    /**
     * Test of save method, of class WriteReference.
     */
    private ArrayList<String> referense1() {
        ArrayList<String> r1 = new ArrayList<>();
        r1.add("@article{W04,");
        r1.add("author = {Whittington, Keith J.},");
        r1.add("title = {Infusing active learning into introductory programming courses},");
        r1.add("journal = {J. Comput. Small Coll.},");
        r1.add("volume = {19},");
        r1.add("number = {5},");
        r1.add("year = {2004},");
        r1.add("pages = {249--259},");
        r1.add("publisher = {Consortium for Computing Sciences in Colleges},");
        r1.add("address = {USA},");
        return r1;
    }
}
