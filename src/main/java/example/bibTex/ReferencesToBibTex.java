package example.bibTex;

/**
 * @author tiera
 */
public interface ReferencesToBibTex {

    String EndFile();

    void EndReference();

    void HederAndItsType(String heder, String type);

    void OneFieldAndItsType(String field, String type);

}
