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
        GetReference r = new GetReference();
        o.greatnewreference(r.referense1());
        o.greatnewreference(r.referense2());
        o.save();
        
    }
}
