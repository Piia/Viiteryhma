package example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String app(Model model) {
        // TODO: Add new Article()
        model.addAttribute("article", null);
        
        return "app";
    }
    
    @PostMapping("/references/article")
    public String addArticleReference(@ModelAttribute Object article) {
        // TODO: Object -> Article
        
        return "app";
    }
    
    @GetMapping("/export")
    public String exportToBibtex(Model model) {
        model.addAttribute("filePath", "/linkki.html");
        
        return "export";
    }
}