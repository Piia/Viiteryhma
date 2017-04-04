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
public class References {

    public References() {
    }
    
    public void run() throws IOException{
        File file = new File("test.bib");
        FileWriter filewriter = new FileWriter(file);
        WriteReference o = new WriteReference(filewriter);
        ReferenceToRightFormat r = new ReferenceToRightFormat();
        r.Entry("inproceedings", "VPL11");
        r.oneKeyField("author", "Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti");
        r.oneKeyField("title", "Extreme Apprenticeship Method in Teaching Programming for Beginners.");
        r.oneKeyField("year", "2011");
        r.oneKeyField("booktitle", "SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education");
        o.greatnewreference(r.referense());
        o.save();
        
    }
}
