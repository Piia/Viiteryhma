package viiteryhma.controller;

import example.bibTex.ReferenceToString;
import viiteryhma.wanhat.OldArticle;
import example.bibTex.References;
import example.bibTex.referencesToBibTex;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import viiteryhma.interfaces.Reference;
import viiteryhma.model.Article;
import viiteryhma.model.Book;
import viiteryhma.model.Inproceedings;
import viiteryhma.repositories.ArticleRepository;
import viiteryhma.repositories.BookRepository;
import viiteryhma.repositories.InproceedingsRepository;

@Controller
public class ApplicationController {
    private Map<String, String> exports = new HashMap<>();
    
    // Tämä toimii ns. tietokantana!
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
    
    @GetMapping("/articles")
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleRepo.findAll());
        return "articles";
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
    
    public String generateBibTex() {
        /*
            Tämä nyt tämmöinen väliaikainen taas.
        */
        
        List<Article> articles = articleRepo.findAll();
        List<Book> books = bookRepo.findAll();
        List<Inproceedings> inproceedings = inproceedingsRepo.findAll();

        referencesToBibTex k = new ReferenceToString();

        for (Article ref : articles) {
            Map<String,String> fields = ref.getFields();
            k.HederAndItsType(fields.get("key"), ref.getType());

            fields.keySet().stream().forEach((name) -> {
                if (!name.equals("key")) {
                  k.OneFieldAndItsType(fields.get(name), name);
                }
            });

            k.EndReference();
        }

        for (Book ref : books) {
            Map<String,String> fields = ref.getFields();
            k.HederAndItsType(fields.get("key"), ref.getType());

            fields.keySet().stream().forEach((name) -> {
                if (!name.equals("key")) {
                  k.OneFieldAndItsType(fields.get(name), name);
                }
            });

            k.EndReference();
        }

        for (Inproceedings ref : inproceedings) {
            Map<String,String> fields = ref.getFields();
            k.HederAndItsType(fields.get("key"), ref.getType());

            fields.keySet().stream().forEach((name) -> {
                if (!name.equals("key")) {
                  k.OneFieldAndItsType(fields.get(name), name);
                }
            });

            k.EndReference();
        }

        return k.EndFile();
    }
}