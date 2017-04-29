package viiteryhma.controller;

import example.bibTex.ReferenceToString;
import example.bibTex.ReferencesToBibTex;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import viiteryhma.model.Article;
import viiteryhma.model.Book;
import viiteryhma.model.Inproceedings;
import viiteryhma.repositories.ArticleRepository;
import viiteryhma.repositories.BookRepository;
import viiteryhma.repositories.InproceedingsRepository;
import viiteryhma.interfaces.Reference;

@Controller
public class ApplicationController {    
    
    
    @Autowired
    private ArticleRepository articleRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private InproceedingsRepository inproceedingsRepo;
    
    protected void initializeModels(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("book", new Book());
        model.addAttribute("inproceedings", new Inproceedings());
    }

    @GetMapping("/")
    public String app(Model model) {
        return "redirect:/new";
    }
    
    @GetMapping("/new")
    public String getNewReference(Model model) {
        this.initializeModels(model);
        return "new";
    }
    
    @GetMapping("/references")
    public String getAllReferences(Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("inproceedings", inproceedingsRepo.findAll());
        
        return "references";
    }
    
    @PostMapping("/new/article")
    public String postNewArticle(Model model, @ModelAttribute Article article) {
        articleRepo.save(article);
        model.addAttribute("success", true);
        
        this.initializeModels(model);
        return "new";
    }
    
    @PostMapping("/new/book")
    public String postNewBook(Model model, @ModelAttribute Book book) {
        bookRepo.save(book);
        model.addAttribute("success", true);
        
        this.initializeModels(model);
        return "new";
    }
    
    @PostMapping("/new/inproceedings")
    public String postNewInproceedings(Model model, @ModelAttribute Inproceedings inproceedings) {
        inproceedingsRepo.save(inproceedings);
        model.addAttribute("success", true);
        
        this.initializeModels(model);
        return "new";
    }
    
    @GetMapping("/export")
    public String getExportReferences(Model model) {
        return "export";
    }
    
    @PostMapping("/export")
    public String postExportReferences(Model model, HttpServletRequest req) {
        //model.addAttribute("success", true);
        String name = req.getParameter("name");
        
        if (name.isEmpty()) {
            name = "references";
        }
        
        return "redirect:/files/" + name + ".bib";
    }
    
    @GetMapping(value="/files/{name}.bib", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ByteArrayResource getBibTexFile() {
        return new ByteArrayResource(this.generateBibTex().getBytes());
    }
    
    protected String generateBibTex() {
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
                if (!name.equals("key") && fields.get(name) != null) {
                  refWriter.OneFieldAndItsType(fields.get(name), name);
                }
            });

            refWriter.EndReference();
        }

        return refWriter.EndFile();
    }
}