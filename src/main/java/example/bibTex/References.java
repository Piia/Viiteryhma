package example.bibTex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tiera
 */
public class References {

    private WriteReference o;
    private ReferenceToRightFormat r;

    public References(File file) throws IOException { //alustaa referaatin
        this.o = new WriteReference(new FileWriter(file, true));
        this.r = new ReferenceToRightFormat();
    }

    public void HederAndItsType(String heder, String type) { //tallentaa sopivaan ArrayList muotoon viitauksen otsikon (heder) ja tämän tyypin (type)
        r.Entry(type, heder);
    }

    public void OneFieldAndItsType(String field, String type) { //tallentaa sopivaan ArrayList mutoon viitauksen kentän (field) ja tämän tyypin (type)
        r.oneKeyField(type, field);
    }

    public void EndReference() throws IOException { //sulkee referaatin (tulostaa kaine ulos arraylist muodosta) ja kirjottaa sen sisällön oikeissa puitteissa referaattiin
        o.greatnewreference(r.referense());
    }

    public void EndFile() throws IOException { // sulkee kirjotettavan tiedoston
        o.save();
    }
}
