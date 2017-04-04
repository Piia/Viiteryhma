/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tiera
 */
public class OneReference {
    private FileWriter fw;

    public OneReference(FileWriter filewriter) {
        fw = filewriter;
    }
    
    public void run() throws IOException{
         fw.write("@article{W04,");
         fw.write("\n");
         this.author();
         this.title();
         this.journal();
         this.volume();
         this.number();
         this.year();
         this.pages();
         this.publisher();
         this.address();
         fw.write("}");
         fw.write("\n");
    }
 
    private void author() throws IOException{
        fw.write("author = {Whittington, Keith J.},");
        fw.write("\n");
    }
    
    private void journal() throws IOException{
       fw.write("journal = {J. Comput. Small Coll.},"); 
       fw.write("\n"); 
    }
    
    private void month() throws IOException{
        fw.write("author = {Whittington, Keith J.},");
        fw.write("\n");
    }
    
    private void note() throws IOException{
        fw.write("author = {Whittington, Keith J.},");
        fw.write("\n");
    }
    
    private void number() throws IOException{
        fw.write("number = {5},");
        fw.write("\n");
    }
    
    private void pages() throws IOException{
        fw.write("pages = {249--259},");
        fw.write("\n");
    }
    
    private void title() throws IOException{
        fw.write("title = {Infusing active learning into introductory programming courses},");
        fw.write("\n");
    }
    
    private void volume() throws IOException{
        fw.write("volume = {19},");
        fw.write("\n");
    }
    
    private void year() throws IOException{
        fw.write("year = {2004},");
        fw.write("\n");
    }
    //wikin mukaan ei ole artikkelissa
    private void publisher() throws IOException{
        fw.write("publisher = {Consortium for Computing Sciences in Colleges},");
        fw.write("\n");
    }
    
    private void address() throws IOException{
        fw.write("address = {USA},");
        fw.write("\n");
    }
}
