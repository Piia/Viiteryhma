/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viiteryhma.References;

import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import viiteryhma.model.Inproceedings;

/**
 *
 * @author Piia Hartikka
 */
public class InproceedingsTest {
    
    private Inproceedings ip;
    
    @Before
    public void setUp() {
        ip = new Inproceedings();
        ip.setAddress("address");
        ip.setAuthor("author");
        ip.setTitle("title");
        ip.setBooktitle("booktitle");
        ip.setYear("year");
        ip.setKey("key");
        ip.setEditor("editor");
        ip.setVolume("volume");
        ip.setSeries("series");
        ip.setPages("pages");
        ip.setMonth("month");
        ip.setOrganization("organization");
        ip.setPublisher("publisher");
        ip.setNote("note");
    }
    
    @Test
    public void setUpTest() {
        assertEquals(ip.getAddress(), "address");
        assertEquals(ip.getAuthor(), "author");
        assertEquals(ip.getTitle(), "title");
        assertEquals(ip.getBooktitle(), "booktitle");
        assertEquals(ip.getYear(), "year");
        assertEquals(ip.getKey(), "key");
        assertEquals(ip.getEditor(), "editor");
        assertEquals(ip.getVolume(), "volume");
        assertEquals(ip.getSeries(), "series");
        assertEquals(ip.getPages(), "pages");
        assertEquals(ip.getMonth(), "month");
        assertEquals(ip.getOrganization(), "organization");
        assertEquals(ip.getPublisher(), "publisher");
        assertEquals(ip.getNote(), "note");
        
    }
    
    @Test
    public void typeTest() {
        assertEquals(ip.getType(), "inproceedings");
    }
    
    @Test
    public void getFieldsTest() {
        Map<String, String> fields = ip.getFields();
        assertEquals(fields.get("address"), "address");
        assertEquals(fields.get("author"), "author");
        assertEquals(fields.get("title"), "title");
        assertEquals(fields.get("booktitle"), "booktitle");
        assertEquals(fields.get("year"), "year");
        assertEquals(fields.get("key"), "key");
        assertEquals(fields.get("editor"), "editor");
        assertEquals(fields.get("volume"), "volume");
        assertEquals(fields.get("series"), "series");
        assertEquals(fields.get("pages"), "pages");
        assertEquals(fields.get("month"), "month");
        assertEquals(fields.get("organization"), "organization");
        assertEquals(fields.get("publisher"), "publisher");
        assertEquals(fields.get("note"), "note");
        
    }

}
