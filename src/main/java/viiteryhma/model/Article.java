/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viiteryhma.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import viiteryhma.interfaces.Reference;

/**
 *
 * @author Piia Hartikka
 */

@Entity
public class Article extends AbstractPersistable<Long> implements Reference {
    private final String type = "article";
    
    //required
    //@NotBlank
    private String author;
    private String title;
    private String journal;
    private String year;
    private String volume;


    //optional:
    private String key;
    private String number;
    private String pages;
    private String month;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public Map<String, String> getFields() {
        Map<String, String> map = new HashMap<>();
    
        map.put("author", author);
        map.put("journal", journal);
        map.put("key", key);
        map.put("month", month);
        map.put("note", note);
        map.put("number", number);
        map.put("pages", pages);
        map.put("title", title);
        map.put("volume", volume);
        map.put("year", year);

        return map;
    }

}
