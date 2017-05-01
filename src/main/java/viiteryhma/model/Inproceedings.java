package viiteryhma.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import viiteryhma.interfaces.Reference;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Piia Hartikka
 */
@Entity
public class Inproceedings extends AbstractPersistable<Long> implements Reference {

    private static final String type = "inproceedings";

    //required
    //@NotBlank ??
    private String author;
    private String title;
    private String booktitle;
    private String year;


    //optional:
    private String key;
    private String editor;
    private String volume;
    private String series;
    private String pages;
    private String address;
    private String month;
    private String organization;
    private String publisher;
    private String note;

    private String tags;

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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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
        map.put("booktitle", booktitle);
        map.put("editor", editor);
        map.put("key", key);
        map.put("month", month);
        map.put("note", note);
        map.put("organization", organization);
        map.put("pages", pages);
        map.put("publisher", publisher);
        map.put("series", series);
        map.put("title", title);
        map.put("volume", volume);
        map.put("year", year);

        return map;
    }
}
