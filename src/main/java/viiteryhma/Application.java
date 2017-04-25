package viiteryhma;

import example.bibTex.ReferenceToString;
import example.bibTex.referencesToBibTex;
import java.io.File;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
        
    }

}   