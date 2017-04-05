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
public class References implements referencesToBibTex {

    private File file;
    private FileWriter filewriter;
    private WriteReference o;
    private ReferenceToRightFormat r;

    public References(File file) throws IOException { //alustaa referaatin
        this.file = file;
        this.filewriter = new FileWriter(file);
        this.o = new WriteReference(filewriter);
        this.r = new ReferenceToRightFormat();
    }
    
    @Override
    public void HederAndItsType(String heder, String type){ //tallentaa sopivaan ArrayList muotoon viitauksen otsikon (heder) ja tämän tyypin (type)
        r.Entry(type, heder);
    }
    
    @Override
    public void OneFieldAndItsType(String field, String type){ //tallentaa sopivaan ArrayList mutoon viitauksen kentän (field) ja tämän tyypin (type)
        r.oneKeyField(type, field);
    }
    
    @Override
    public void EndReference() throws IOException{ //sulkee referaatin (tulostaa kaine ulos arraylist muodosta) ja kirjottaa sen sisällön oikeissa puitteissa referaattiin
        o.greatnewreference(r.referense());
    }
    
    @Override
    public void EndFile() throws IOException{ // sulkee kirjotettavan tiedoston
        o.save();
    }
}
