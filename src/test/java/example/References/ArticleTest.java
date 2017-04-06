/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.References;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleTest {

    Article article;

    public ArticleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        article = new Article(Arrays.asList("Anthony Robins", "Janet Rountree", "Nathan Rountree"),
                "Learning and teaching programming: A review and discussion",
                "Computer Science Education", "2003", "13");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsTheRequiredAttributesCorrectly() {
        String[] authors = {"Anthony Robins", "Janet Rountree", "Nathan Rountree"};
        for(String author : authors) {
            assertTrue(article.getAuthor().contains(author));
        }
        assertTrue(article.getAuthor().size() == authors.length);
        
        assertEquals("Learning and teaching programming: A review and discussion", article.getTitle());
        assertEquals("Computer Science Education", article.getJournal());
        assertEquals("2003", article.getYear());
        assertEquals("13", article.getVolume());
    }

    @Test
    public void constructorSetsTheOptionalAttributesToEmptyStrings() {
        assertTrue(article.getNumber().isEmpty()
                && article.getPages().isEmpty()
                && article.getMonth().isEmpty()
                && article.getNote().isEmpty()
                && article.getKey().isEmpty());
    }
    
    @Test
    public void settingTheOptionalAttributesNumberPagesAndKeyWorks() {
        article.setNumber("test number");
        article.setPages("12-13, 34-38");
        article.setKey("key");
        
        assertEquals("test number", article.getNumber());
        assertEquals("12-13, 34-38", article.getPages());
        assertEquals("key", article.getKey());
    }

    @Test
    public void toStringProducesTheRightOutputWhenOptionalAttributesMonthAndNoteAreSet() {
        article.setMonth("August");
        article.setNote("toString test");
                
        assertEquals("Authors: Anthony Robins, Janet Rountree and Nathan Rountree\n"
                + "Title: Learning and teaching programming: A review and discussion\n"
                + "Journal: Computer Science Education\n"
                + "Year: 2003\n"
                + "Volume: 13\n"
                + "Month: August\n"
                + "Note: toString test\n\n", article.toString());
    }
    
    @Test
    public void toStringProducesTheRightOutputWhenOptionalAttributesNumberPagesAndKeyAreSet() {
        article.setNumber("August");
        article.setPages("54-59");
        article.setKey("jingle bells");
                
        assertEquals("Authors: Anthony Robins, Janet Rountree and Nathan Rountree\n"
                + "Title: Learning and teaching programming: A review and discussion\n"
                + "Journal: Computer Science Education\n"
                + "Year: 2003\n"
                + "Volume: 13\n"
                + "Number: August\n"
                + "Pages: 54-59\n"
                + "Key: jingle bells\n\n", article.toString());
    }
}
