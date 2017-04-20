package viiteryhma;

import viiteryhma.wanhat.MockDatabase;
import viiteryhma.wanhat.OldArticle;
import static org.hamcrest.Matchers.containsString;
import org.junit.Before;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import viiteryhma.model.Article;
import viiteryhma.model.Book;
import viiteryhma.model.Inproceedings;
import viiteryhma.repositories.ArticleRepository;
import viiteryhma.repositories.BookRepository;
import viiteryhma.repositories.InproceedingsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ArticleRepository articleRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private InproceedingsRepository inproceedingsRepo;
    
    public ApplicationControllerTest() {
    }
    
    @Before
    public void setUp() {
        articleRepo.deleteAll();
        bookRepo.deleteAll();
        inproceedingsRepo.deleteAll();
    }
    

    
    protected Article getMockArticle() {
        Article article = new Article();
        article.setAuthor("Pekka");
        article.setTitle("Otsikko");
        article.setJournal("Julkaisu");
        article.setYear("2017");
        article.setVolume("1");
        
        return article;
    }
    
    protected Book getMockBook() {
        Book book = new Book();
        book.setAuthor("Pekka");
        book.setTitle("Otsikko");
        book.setPublisher("Julkaisija");
        book.setYear("2017");
        
        return book;
    }
    
    protected Inproceedings getMockInproceedings() {
        Inproceedings inproceedings = new Inproceedings();
        inproceedings.setAuthor("Pekka");
        inproceedings.setTitle("Otsikko");
        inproceedings.setBooktitle("Kirjan otsikko");
        inproceedings.setYear("2017");
        
        return inproceedings;
    }

    @Test
    public void testReturnPageNew() throws Exception {
        //MockDatabase.reset();
        this.mockMvc
                .perform(get("/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2>Add a reference</h2>")));
    }

    @Test
    public void testAddANewArticleReference() throws Exception {              
        this.mockMvc
                .perform(post("/new/article", this.getMockArticle()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("success", true));        
    }
    
    @Test
    public void testAddANewBookReference() throws Exception {              
        this.mockMvc
                .perform(post("/new/book", this.getMockBook()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("success", true));        
    }
    
    @Test
    public void testAddANewInproceedingsReference() throws Exception {             
        this.mockMvc
                .perform(post("/new/inproceedings", getMockInproceedings()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("success", true));        
    }
    
    @Test
    public void testReturnPageExport() throws Exception {
        this.mockMvc
                .perform(get("/export"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<h2>Export references</h2>")));
    }
    
    @Test
    public void testGeneratedBibTexIsEmptyWhenNoReferences() throws Exception {
        this.mockMvc
                .perform(post("/export").param("name", ""))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/files/references.bib"));
        
        this.mockMvc
                .perform(get("/files/references.bib"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
    
    @Test
    public void testGeneratedBibTexHasGivenName() throws Exception {
        this.mockMvc
                .perform(post("/export").param("name", "cool_references"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/files/cool_references.bib"));
    }
    
    @Test
    public void testGeneratedBibTexHasOneReferenceWhenOneAddedToDb() throws Exception {
        articleRepo.save(getMockArticle());
        
        this.mockMvc
                .perform(get("/files/references.bib"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("@article")));
    }
    
    @Test
    public void testGeneratedBibTexHasMultipleReferencesWhenMultipleAddedToDb() throws Exception {
        articleRepo.save(getMockArticle());
        bookRepo.save(getMockBook());
        inproceedingsRepo.save(getMockInproceedings());
        
        this.mockMvc
                .perform(get("/files/references.bib"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("@article")))
                .andExpect(content().string(containsString("@book")))
                .andExpect(content().string(containsString("@inproceedings")));
    }
}