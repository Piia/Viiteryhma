package example;

import example.bibTex.References;
import example.bibTex.referencesToBibTex;
import java.io.File;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        File l = new File("test.bib");
        referencesToBibTex k = new References(l);
        
        k.HederAndItsType("VPL11", "inproceedings");
        k.OneFieldAndItsType("Vihavainen, Arto and Paksula, Matti and Luukkainen, Matti", "author");
        k.OneFieldAndItsType("Extreme Apprenticeship Method in Teaching Programming for Beginners.", "title");
        k.OneFieldAndItsType("2011", "year");
        k.OneFieldAndItsType("SIGCSE '11: Proceedings of the 42nd SIGCSE technical symposium on Computer science education", "booktitle");
        k.EndReference();
        
        k.HederAndItsType("BA04", "book");
        k.OneFieldAndItsType("Beck, Kent and Andres, Cynthia", "author");
        k.OneFieldAndItsType("author", "title");
        k.OneFieldAndItsType("2004", "year");
        k.OneFieldAndItsType("Addison-Wesley Professional", "publisher");
        k.EndReference();
        
        k.EndFile();
    }

}   