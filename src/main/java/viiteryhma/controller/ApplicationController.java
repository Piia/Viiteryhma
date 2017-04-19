package viiteryhma.controller;

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

    @GetMapping("/")
    public String app(Model model) {
        //model.addAttribute("article", new Article());
        return "redirect:/new";
    }
    
    @GetMapping("/new")
    public String getNewReference(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("book", new Book());
        model.addAttribute("inproceedings", new Inproceedings());
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
        model.addAttribute("article", new Article());
        return "new";
    }
    
    @PostMapping("/new/book")
    public String postNewBook(Model model, @ModelAttribute Book book) {
        bookRepo.save(book);
        model.addAttribute("success", true);
        model.addAttribute("book", new Book());
        return "new";
    }
    
    @PostMapping("/new/inproceedings")
    public String postNewInproceedings(Model model, @ModelAttribute Inproceedings inproceedings) {
        inproceedingsRepo.save(inproceedings);
        model.addAttribute("success", true);
        model.addAttribute("inproceedings", new Inproceedings());
        return "new";
    }
    
    @GetMapping("/export")
    public String getExportReferences(Model model) {
        return "export";
    }
    
    @PostMapping("/export")
    public String postExportReferences(Model model) {
        model.addAttribute("success", true);
        
        String key = String.format("%d%m%Y_%H%M", new Date());
        model.addAttribute("bibtex_file", "/files/references_" + key + ".bib");
        
        return "export";
    }
    
    @GetMapping(value="/files/references_{key}.bib", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ByteArrayResource getBibTexFile(@PathVariable String key) {
        System.out.println("Key: " + key);
        return new ByteArrayResource(exports.get(key).getBytes());
    }
    
//    @PostMapping("/export")
//    @ResponseBody
//    public FileSystemResource postExportReferences(Model model) {
//        File generated = this.generateBibTex();
//        
//        model.addAttribute("filePath", "/files/references.bib");
//        model.addAttribute("success", true);
//        
//        return new FileSystemResource(generated);
//    }
    
//    public File generateBibTex() {
//        try {
//            
//            List<Article> references = articleRepo.findAll();
//            File l = new File("src/main/resources/static/files/references.bib");
//            referencesToBibTex k = new References(l);
//
//            for (Article ref : references) {
//                k.HederAndItsType(ref.getKey(), ref.getType());
//                Map<String,String> fields = ref.getFields();
//
//                fields.keySet().stream().forEach((key) -> {
//                    k.OneFieldAndItsType(fields.get(key), key);
//                });
//
//                k.EndReference();
//            }
//
//            k.EndFile();
//                        
//            return l;
//        } catch (Exception e) {
//            System.out.println("Error generating BibTeX: " + e);
//            return null;
//        }
//        
//    }
}