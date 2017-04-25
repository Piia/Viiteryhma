package viiteryhma;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Stepdefs {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080";
    }

    @Given("^add reference of type \"([^\"]*)\" is selected$")
    public void add_reference(String referenceType) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm(referenceType);
    }

    @Given("^there is an article in the database$")
    public void an_article_is_in_db() throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("article");

        this.required_article_fields_are_given("key", "author", "title", "journal", "volume", "year");
        this.article_form_is_submitted();
    }

    @Given("^there is an article containing the text \"([^\"]*)\" in the database$")
    public void an_article_containing_text_is_in_db(String text) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("article");

        this.required_article_fields_are_given("key", "author", "title " + text, "journal", "volume", "year");
        this.article_form_is_submitted();
    }
    
    @Given("^there is an article not containing the text \"([^\"]*)\" in the database$")
    public void an_article_not_containing_text_is_in_db(String text) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("article");
        
        String stringWithoutGivenText = this.createStringNotContaining(text);

        this.required_article_fields_are_given(stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText);
        this.article_form_is_submitted();
    }

    @Given("^there is a book in the database$")
    public void a_book_is_in_db() throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("book");

        this.required_book_fields_are_given("key", "author", "title", "publisher", "year");
        this.book_form_is_submitted();
    }
    
    @Given("^there is a book containing the text \"([^\"]*)\" in the database$")
    public void a_book_containing_text_is_in_db(String text) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("book");

        this.required_book_fields_are_given("key", "author", "title " + text, "publisher", "year");
        this.book_form_is_submitted();
    }

    @Given("^there is a book not containing the text \"([^\"]*)\" in the database$")
    public void a_book_not_containing_text_is_in_db(String text) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("book");

        String stringWithoutGivenText = this.createStringNotContaining(text);

        this.required_book_fields_are_given(stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText);
        this.book_form_is_submitted();
    }

    @Given("^there is an inproceedings in the database$")
    public void an_inproceedings_is_in_db() throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("inproceedings");

        this.required_inproceedings_fields_are_given("key", "author", "title", "booktitle", "year");
        this.inproceedings_form_is_submitted();
    }
    
    @Given("^there is an inproceedings not containing the text \"([^\"]*)\" in the database$")
    public void an_inproceedings_not_containing_text_is_in_db(String text) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm("inproceedings");
        
        String stringWithoutGivenText = this.createStringNotContaining(text);

        this.required_inproceedings_fields_are_given(stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText, stringWithoutGivenText);
        this.inproceedings_form_is_submitted();
    }

    @When("^list references is selected$")
    public void list_references_is_selected() throws Throwable {
        driver.get(baseUrl + "/references");
    }

    @When("^references are filtered using \"([^\"]*)\"$")
    public void filter_references(String filterText) throws Throwable {
        WebElement element = driver.findElement(By.id("filter"));
        element.sendKeys(filterText);
    }

    @When("^valid value \"([^\"]*)\" of type \"([^\"]*)\" for reference-type \"([^\"]*)\" is given$")
    public void valid_key_is_given(String value, String type, String referenceType) throws Throwable {
        giveValueToField(value, referenceType + "-" + type);
    }

    @When("^valid parameters for \\(key \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", journal \"([^\"]*)\", volume \"([^\"]*)\", year \"([^\"]*)\"\\) for all required article-fields are given$")
    public void required_article_fields_are_given(String key, String author, String title, String journal, String volume, String year) throws Throwable {
        giveValueToField(key, "article-key");
        giveValueToField(author, "article-author");
        giveValueToField(title, "article-title");
        giveValueToField(journal, "article-journal");
        giveValueToField(volume, "article-volume");
        giveValueToField(year, "article-year");
    }

    @When("^valid parameters for \\(key \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", publisher \"([^\"]*)\", year \"([^\"]*)\"\\) for all required book-fields are given$")
    public void required_book_fields_are_given(String key, String author, String title, String publisher, String year) throws Throwable {
        giveValueToField(key, "book-key");
        giveValueToField(author, "book-author");
        giveValueToField(title, "book-title");
        giveValueToField(publisher, "book-publisher");
        giveValueToField(year, "book-year");
    }

    @When("^valid parameters for \\(key \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", booktitle \"([^\"]*)\", year \"([^\"]*)\"\\) for all required inproceedings-fields are given$")
    public void required_inproceedings_fields_are_given(String key, String author, String title, String booktitle, String year) throws Throwable {
        giveValueToField(key, "inproceedings-key");
        giveValueToField(author, "inproceedings-author");
        giveValueToField(title, "inproceedings-title");
        giveValueToField(booktitle, "inproceedings-booktitle");
        giveValueToField(year, "inproceedings-year");
    }

    @When("^article form is submitted$")
    public void article_form_is_submitted() throws Throwable {
        WebElement element = driver.findElement(By.id("add-article"));
        element.click();
    }

    @When("^book form is submitted$")
    public void book_form_is_submitted() throws Throwable {
        WebElement element = driver.findElement(By.id("add-book"));
        element.click();
    }

    @When("^inproceedings form is submitted$")
    public void inproceedings_form_is_submitted() throws Throwable {
        WebElement element = driver.findElement(By.id("add-inproceedings"));
        element.click();
    }

    //shallow test..?
    @Then("^reference is added$")
    public void reference_is_added() throws Throwable {
//        try{ Thread.sleep(30000); } catch(Exception e){}  // suoritus pysähtyy 120 sekunniksi
        assertTrue(driver.getPageSource().contains("Reference added successfully!"));
    }

    @Then("^reference is not added$")
    public void reference_is_not_added() throws Throwable {
        assertTrue(!driver.getPageSource().contains("Reference added successfully!"));
    }

    @Then("^articles are listed$")
    public void articles_are_listed() throws Throwable {
        assertTrue(driver.getPageSource().contains("<h3>Articles</h3>"));        
        assertTrue(this.thereAreVisibleArticles());   
    }
    
    @Then("^articles are not listed$")
    public void articles_are_not_listed() throws Throwable {       
        assertTrue(!this.thereAreVisibleArticles());   
    }

    @Then("^books are listed$")
    public void books_are_listed() throws Throwable {
        assertTrue(driver.getPageSource().contains("<h3>Books</h3>"));
        assertTrue(this.thereAreVisibleBooks());
    }

    @Then("^books are not listed$")
    public void books_are_not_listed() throws Throwable {
        assertTrue(!this.thereAreVisibleBooks());
    }

    @Then("^inproceedings are listed$")
    public void inproceedings_are_listed() throws Throwable {
        assertTrue(driver.getPageSource().contains("<h3>Inproceedings</h3>"));
        assertTrue(this.thereAreVisibleInproceedings());
    }

    @Then("^inproceedings are not listed$")
    public void inproceedings_are_not_listed() throws Throwable {
        assertTrue(!this.thereAreVisibleInproceedings());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void giveValueToField(String value, String field) {
        WebElement element = driver.findElement(By.id(field));
        element.sendKeys(value);
    }

    private void selectReferenceTypeForInputForm(String referenceType) {
        WebElement element = driver.findElement(By.id("reference-type"));
        Select select = new Select(element);
        select.selectByValue(referenceType);
    }

    private String createStringNotContaining(String text) {
        return text.equals("q") ? "a" : "q";
    }
    
    private boolean thereAreVisibleArticles() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object response = js.executeScript(this.javascriptForVisibleArticlesQuery());
        return response.toString().equals("true");
    }
    
    private boolean thereAreVisibleBooks() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object response = js.executeScript(this.javascriptForVisibleBooksQuery());
        return response.toString().equals("true");
    }
    
    private boolean thereAreVisibleInproceedings() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object response = js.executeScript(this.javascriptForVisibleInproceedingsQuery());
        return response.toString().equals("true");
    }
    
    private String javascriptForVisibleArticlesQuery() {
        return "return (function anyArticlesVisible() {"
                + "var articles = document.getElementsByClassName('articles');"
                + "for(var i = 0; i < articles.length; i += 1) {"
                + "if(articles[i].style.display != undefined && articles[i].style.display !== \"none\") {"
                + "return true;}}"
                + "return false;})();";
    }
    
    private String javascriptForVisibleBooksQuery() {
        return "return (function anyBooksVisible() {"
                + "var books = document.getElementsByClassName('books');"
                + "for(var i = 0; i < books.length; i += 1) {"
                + "if(books[i].style.display != undefined && books[i].style.display !== \"none\") {"
                + "return true;}}"
                + "return false;})();";
    }
    
    private String javascriptForVisibleInproceedingsQuery() {
        return "return (function anyInproceedingsVisible() {"
                + "var inproceedings = document.getElementsByClassName('inproceedings');"
                + "for(var i = 0; i < inproceedings.length; i += 1) {"
                + "if(inproceedings[i].style.display != undefined && inproceedings[i].style.display !== \"none\") {"
                + "return true;}}"
                + "return false;})();";
    }

    // tieran koodit:
    /*
     References r;
     File l;

     @Given("^References is initialized$")
     public void references_is_initialized() throws Throwable {
     l = new File("test3.bib");
     r = new References(l);
     }

     @When("^heder_and_its_type_is_set (\\d+)(+\\d+)$")
     public void heder_and_its_type_is_set(String heder, String type) throws Throwable {
     r.HederAndItsType(heder, type);
     }

     @When("^reference_list_is_closed$")
     public void reference_list_is_closed() throws Throwable {
     r.EndReference();
     r.EndFile();
     }
    
     @Then("^the value should be (\\d+)$")
     public void the_value_should_be(String val) throws Throwable {
     Scanner t = new Scanner(l);
     String g = t.nextLine();
     assertEquals(val, g);
     }
     */
}
