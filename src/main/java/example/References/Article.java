/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.References;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Article {
    private final String type = "article";
    //required:
    //List luultavasti järkevämpi kuin pelkkä String, erityisesti kun myöhemmin listataan viitteet

    private List<String> author;
    private String title;
    private String journal;
    //int? String? Year?
    private String year;
    //int? String?
    private String volume;

    //optional:
    //int?
    private String number;
    private String pages;
    private String month;
    private String note;
    //A hidden field used for specifying or overriding the alphabetical order of entries
    //(when the "author" and "editor" fields are missing). Note that this is very
    //different from the key (mentioned just after this list) that is used to cite
    //or cross-reference the entry. (https://en.wikipedia.org/wiki/BibTeX)
    private String key;

    //or Article(String title, String journal, int year, String volume, String... author) ?
    public Article(List<String> author, String title, String journal, String year, String volume) {
        this.author = author;
        this.title = title;
        this.journal = journal;
        this.year = year;
        this.volume = volume;

        this.number = "";
        this.pages = "";
        this.month = "";
        this.note = "";
        this.key = "";
    }
    
    public Article() {
        this.author = new ArrayList<>();
        this.title = "";
        this.journal = "";
        this.year = "";
        this.volume = "";
        
        this.number = "";
        this.pages = "";
        this.month = "";
        this.note = "";
        this.key = "";
    }

    //ugly, but can be used for the bibtex-conversion for now
    public List<List<String>> getAll() {
        ArrayList<List<String>> attributes = new ArrayList<>(2);
        attributes.add(this.author);

        ArrayList<String> others = new ArrayList<>();
        others.add(title);
        others.add(journal);
        others.add(year);
        others.add(volume);
        others.add(number);
        others.add(pages);
        others.add(month);
        others.add(note);
        others.add(key);
        
        attributes.add(others);

        return attributes;
    }
    
    public void setAuthor(List<String> author) {
        this.author = author;
    }
    
    public void setAuthor(String author) {
        // (String)"author1, author2" => (String[])[author1, author2]
        this.author = new ArrayList<>();
        String[] authors = author.split(",");
        
        for (String a : authors) {
            this.author.add(a.trim());
        }
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setJournal(String journal) {
        this.journal = journal;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public void setVolume(String volume) {
        this.volume = volume;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getType() {
        return type;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getJournal() {
        return journal;
    }

    public String getYear() {
        return year;
    }

    public String getVolume() {
        return volume;
    }

    public String getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public String getMonth() {
        return month;
    }

    public String getNote() {
        return note;
    }

    public String getKey() {
        return key;
    }

    //testaukseen ehkä kiva...
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        
        int numberOfAuthors = this.author.size();
        
        builder.append("Authors: " + (numberOfAuthors > 0 ? this.author.get(0) : ""));
        for (int i = 1; i < numberOfAuthors; i++) {
            if (i == numberOfAuthors - 1) {
                builder.append(" and " + this.author.get(i));
                break;
            }
            builder.append(", " + this.author.get(i));
        }
        builder.append("\n");

        builder.append("Title: " + this.title + "\n");
        builder.append("Journal: " + this.journal + "\n");
        builder.append("Year: " + this.year + "\n");
        builder.append("Volume: " + this.volume + "\n");

        if (!this.number.isEmpty()) {
            builder.append("Number: " + this.number + "\n");
        }

        if (!this.pages.isEmpty()) {
            builder.append("Pages: " + this.pages + "\n");
        }

        if (!this.month.isEmpty()) {
            builder.append("Month: " + this.month + "\n");
        }

        if (!this.note.isEmpty()) {
            builder.append("Note: " + this.note + "\n");
        }

        //necessary?
        if (!this.key.isEmpty()) {
            builder.append("Key: " + this.key + "\n");
        }

        builder.append("\n");
        return builder.toString();
    }
    
    public Map<String, String> getFields() {
        Map<String, String> map = new HashMap<>();
        map.put("author", String.join(", ", author));
        map.put("title", title);
        map.put("journal", journal);
        map.put("year", year);
        map.put("volume", volume);
        map.put("number", number);
        map.put("pages", pages);
        map.put("month", month);
        map.put("note", note);
        
        return map;
    }
}
