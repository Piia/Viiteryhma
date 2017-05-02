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
import viiteryhma.model.Book;

/**
 *
 * @author Piia Hartikka
 */
public class BookTest {
    
    private Book book;
    
    @Before
    public void setUp() {
        book = new Book();
        book.setAddress("address");
        book.setAuthor("author");
        book.setTitle("title");
        book.setYear("year");
        book.setKey("key");
        book.setVolume("volume");
        book.setSeries("series");
        book.setEdition("edition");
        book.setMonth("month");
        book.setPublisher("publisher");
        book.setNote("note");
        book.setNumber("number");
        book.setTags("tag1,tag2,tag 3");
    }
    
    @Test
    public void setUpTest() {
        assertEquals(book.getAddress(), "address");
        assertEquals(book.getAuthor(), "author");
        assertEquals(book.getTitle(), "title");
        assertEquals(book.getYear(), "year");
        assertEquals(book.getKey(), "key");
        assertEquals(book.getVolume(), "volume");
        assertEquals(book.getSeries(), "series");
        assertEquals(book.getEdition(), "edition");
        assertEquals(book.getNumber(), "number");
        assertEquals(book.getMonth(), "month");
        assertEquals(book.getPublisher(), "publisher");
        assertEquals(book.getNote(), "note");
        assertEquals(book.getTags(), "tag1,tag2,tag 3");
    }
    
    @Test
    public void typeTest() {
        assertEquals(book.getType(), "book");
    }
    
    @Test
    public void getFieldsTest() {
        Map<String, String> fields = book.getFields();
        assertEquals(fields.get("address"), "address");
        assertEquals(fields.get("author"), "author");
        assertEquals(fields.get("title"), "title");
        assertEquals(fields.get("year"), "year");
        assertEquals(fields.get("key"), "key");
        assertEquals(fields.get("volume"), "volume");
        assertEquals(fields.get("series"), "series");
        assertEquals(fields.get("edition"), "edition");
        assertEquals(fields.get("number"), "number");
        assertEquals(fields.get("month"), "month");
        assertEquals(fields.get("publisher"), "publisher");
        assertEquals(fields.get("note"), "note");
        
        
    }

}
