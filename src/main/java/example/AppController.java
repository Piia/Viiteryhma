package example;

import example.References.Article;
import example.bibTex.References;
import example.bibTex.referencesToBibTex;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @GetMapping("/")
    public String app(Model model) {
        // Default page
        return "redirect:/new";
    }
    
    @GetMapping("/new")
    public String getNewReference(Model model) {
        model.addAttribute("article", new Article());
        return "new";
    }
    
    @PostMapping("/new")
    public String postNewReference(Model model, @ModelAttribute Article article) {
        MockDatabase.add(article);
        
        model.addAttribute("success", true);
        
        // Reset
        model.addAttribute("article", new Article());
        return "new";
    }
    
    @GetMapping("/export")
    public String getExportReferences(Model model) {
        return "export";
    }
    
    @PostMapping("/export")
    @ResponseBody
    public FileSystemResource postExportReferences(Model model) {
        File generated = this.generateBibTex();
        
        model.addAttribute("filePath", "/files/references.bib");
        model.addAttribute("success", true);
        
        return new FileSystemResource(generated);
    }
    
    public File generateBibTex() {
        try {
            
            List<Article> references = MockDatabase.getAll();
            File l = new File("src/main/resources/static/files/references.bib");
            referencesToBibTex k = new References(l);

            for (Article ref : references) {
                k.HederAndItsType(ref.getKey(), ref.getType());
                Map<String,String> fields = ref.getFields();

                fields.keySet().stream().forEach((key) -> {
                    k.OneFieldAndItsType(fields.get(key), key);
                });

                k.EndReference();
            }

            k.EndFile();
                        
            return l;
        } catch (Exception e) {
            System.out.println("Error generating BibTeX: " + e);
            return null;
        }
        
    }
}