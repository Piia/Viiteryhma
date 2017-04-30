package viiteryhma.model;

import example.bibTex.ReferenceToString;
import example.bibTex.ReferencesToBibTex;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viiteryhma.interfaces.Reference;
import viiteryhma.repositories.ArticleRepository;
import viiteryhma.repositories.BookRepository;
import viiteryhma.repositories.InproceedingsRepository;

/** 
 *
 * @author mikkotiainen
 */
@Service
public class BibTexGenerator {
    
    @Autowired
    private ArticleRepository articleRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private InproceedingsRepository inproceedingsRepo;
    
    public String generateBibTex() {
        /*
            Tämä nyt tämmöinen hieno production ready!
        */

        List<Reference> references = new ArrayList<>();
        references.addAll(articleRepo.findAll());
        references.addAll(bookRepo.findAll());
        references.addAll(inproceedingsRepo.findAll());

        ReferencesToBibTex refWriter = new ReferenceToString();
        for (Reference ref : references) {
            Map<String,String> fields = ref.getFields();
            refWriter.HederAndItsType(fields.get("key"), ref.getType());

            fields.keySet().stream().forEach((name) -> {
                if (!name.equals("key")) {
                  refWriter.OneFieldAndItsType(fields.get(name), name);
                }
            });

            refWriter.EndReference();
        }

        return refWriter.EndFile();
    }
    
}
