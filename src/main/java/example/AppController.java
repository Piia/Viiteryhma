package example;

import example.References.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String postExportReferences(Model model) {
        // TODO: Create using BibTex
        model.addAttribute("filePath", "/linkki.html");
        model.addAttribute("success", true);
        return "export";
    }
}