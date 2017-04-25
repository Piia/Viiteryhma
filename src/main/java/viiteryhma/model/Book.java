/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viiteryhma.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import viiteryhma.interfaces.Reference;

@Entity
public class Book extends AbstractPersistable<Long> implements Reference {
    private final String type = "book";
    
    //required
    //@NotBlank ??
    private String author;
    private String editor;
    private String title;
    private String publisher;
    private String year;


    //optional:
    private String key;
    private String volume;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;
    private String number;
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
    
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Map<String, String> getFields() {
        Map<String, String> map = new HashMap<>();
        
        map.put("address", address);
        map.put("author", author);
        map.put("editor", editor);
        map.put("edition", edition);
        map.put("key", key);
        map.put("month", month);
        map.put("note", note);
        map.put("number", number);
        map.put("publisher", publisher);
        map.put("series", series);
        map.put("title", title);
        map.put("volume", volume);
        map.put("year", year);

        return map;
    }


}
