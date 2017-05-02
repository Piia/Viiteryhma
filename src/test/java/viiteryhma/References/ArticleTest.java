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
import viiteryhma.model.Article;

/**
 *
 * @author Piia Hartikka
 */
public class ArticleTest {
    
    private Article article;
    
    @Before
    public void setUp() {
        article = new Article();
        article.setAuthor("author");
        article.setTitle("title");
        article.setJournal("journal");
        article.setYear("year");
        article.setKey("key");
        article.setVolume("volume");
        article.setMonth("month");
        article.setNote("note");
        article.setNumber("number");
        article.setTags("tag1,tag2,tag 3");
    }
    
    @Test
    public void setUpTest() {
        assertEquals(article.getAuthor(), "author");
        assertEquals(article.getTitle(), "title");
        assertEquals(article.getYear(), "year");
        assertEquals(article.getKey(), "key");
        assertEquals(article.getVolume(), "volume");
        assertEquals(article.getNumber(), "number");
        assertEquals(article.getMonth(), "month");
        assertEquals(article.getNote(), "note");
        assertEquals(article.getTags(), "tag1,tag2,tag 3");
    }
    
    @Test
    public void typeTest() {
        assertEquals(article.getType(), "article");
    }
    
    @Test
    public void getFieldsTest() {
        Map<String, String> fields = article.getFields();
        assertEquals(fields.get("author"), "author");
        assertEquals(fields.get("title"), "title");
        assertEquals(fields.get("year"), "year");
        assertEquals(fields.get("key"), "key");
        assertEquals(fields.get("volume"), "volume");
        assertEquals(fields.get("number"), "number");
        assertEquals(fields.get("month"), "month");
        assertEquals(fields.get("note"), "note");
        assertEquals(fields.get("journal"), "journal");
    }

}


//    @Test
//    public void toStringProducesTheRightOutputWhenOptionalAttributesMonthAndNoteAreSet() {
//        article.setMonth("August");
//        article.setNote("toString test");
//                
//        assertEquals("Authors: Anthony Robins, Janet Rountree and Nathan Rountree\n"
//                + "Title: Learning and teaching programming: A review and discussion\n"
//                + "Journal: Computer Science Education\n"
//                + "Year: 2003\n"
//                + "Volume: 13\n"
//                + "Month: August\n"
//                + "Note: toString test\n\n", article.toString());
//    }
//    
//    @Test
//    public void toStringProducesTheRightOutputWhenOptionalAttributesNumberPagesAndKeyAreSet() {
//        article.setNumber("August");
//        article.setPages("54-59");
//        article.setKey("jingle bells");
//                
//        assertEquals("Authors: Anthony Robins, Janet Rountree and Nathan Rountree\n"
//                + "Title: Learning and teaching programming: A review and discussion\n"
//                + "Journal: Computer Science Education\n"
//                + "Year: 2003\n"
//                + "Volume: 13\n"
//                + "Number: August\n"
//                + "Pages: 54-59\n"
//                + "Key: jingle bells\n\n", article.toString());
//    }
