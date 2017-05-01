package example.bibTex;

import example.bibTex.characters.StringWhitSpecialCharacters;

/**
 * @author tiera
 */
public class ReferenceToString implements ReferencesToBibTex {
    private StringReference o;
    private ReferenceToRightFormat r;
    private StringWhitSpecialCharacters g;

    public ReferenceToString() { //alustaa referaatin
        this.o = new StringReference();
        this.r = new ReferenceToRightFormat();
        this.g = new StringWhitSpecialCharacters();
    }

    @Override
    public void HederAndItsType(String heder, String type) { //tallentaa sopivaan ArrayList muotoon viitauksen otsikon (heder) ja tämän tyypin (type)
        r.Entry(g.specialCharacters(type), g.specialCharacters(heder));
    }

    @Override
    public void OneFieldAndItsType(String field, String type) { //tallentaa sopivaan ArrayList mutoon viitauksen kentän (field) ja tämän tyypin (type)
        r.oneKeyField(g.specialCharacters(type), g.specialCharacters(field));
    }

    @Override
    public void EndReference() { //sulkee referaatin (tulostaa kaine ulos arraylist muodosta) ja kirjottaa sen sisällön oikeissa puitteissa referaattiin
        o.greatnewreference(r.referense());
    }

    @Override
    public String EndFile() { // sulkee kirjotettavan tiedoston
        return o.save();

    }
}
