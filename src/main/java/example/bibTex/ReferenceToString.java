/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.bibTex;

/**
 *
 * @author tiera
 */
public class ReferenceToString implements referencesToBibTex{
    private StringReference o;
    private ReferenceToRightFormat r;

    public ReferenceToString(){ //alustaa referaatin
        this.o = new StringReference();
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
    public void EndReference() { //sulkee referaatin (tulostaa kaine ulos arraylist muodosta) ja kirjottaa sen sisällön oikeissa puitteissa referaattiin
        o.greatnewreference(r.referense());
    }
    
    @Override
    public String EndFile(){ // sulkee kirjotettavan tiedoston
        return o.save();
        
    }
}
