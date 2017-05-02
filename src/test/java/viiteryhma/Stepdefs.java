package viiteryhma;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.File;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        
        File file;
        if (System.getProperty("os.name").matches("Mac OS X")) {
            file = new File("lib/macgeckodriver");
        } else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            file = new File("lib/geckodriver.exe");   
        } else {
            file = new File("lib/geckodriver");
        }
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        this.driver = new FirefoxDriver();
        //this.driver = new HtmlUnitDriver();
        this.baseUrl = "http://localhost:8080";
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^add reference of type \"([^\"]*)\" is selected$")
    public void add_reference(String referenceType) throws Throwable {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm(referenceType);
    }
    
    @Given("^there is a reference of type \"([^\"]*)\" in the database$")
    public void a_reference_is_in_db(String referenceType) throws Throwable {
        this.addReference(referenceType, true, "");
    }
    
    @Given("^there is a reference of type \"([^\"]*)\" containing the text \"([^\"]*)\" in the database$")
    public void a_reference_containing_text_is_in_db(String referenceType, String text) throws Throwable {
        this.addReference(referenceType, true, text);
    }

    @Given("^there is a reference of type \"([^\"]*)\" not containing the text \"([^\"]*)\" in the database$")
    public void a_reference_not_containing_text_is_in_db(String referenceType, String text) throws Throwable {
       this.addReference(referenceType, false, text);
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

    @When("^reference form for \"([^\"]*)\" is submitted$")
    public void reference_form_is_submitted(String referenceType) throws Throwable {
        submitReferenceForm(referenceType);
    }

    @Then("^reference is added$")
    public void reference_is_added() throws Throwable {
        try{ Thread.sleep(3000); } catch(Exception e){}
        assertTrue(driver.getPageSource().contains("added"));
    }

    @Then("^reference is not added$")
    public void reference_is_not_added() throws Throwable {
        assertTrue(!driver.getPageSource().contains("Reference added successfully!"));
    }

    @Then("^references of type \"([^\"]*)\" are listed$")
    public void references_of_type_are_listed(String referenceType) throws Throwable {
        assertTrue(this.thereAreVisibleReferencesOfType(referenceType));
    }

    @Then("^references of type \"([^\"]*)\" are not listed$")
    public void references_of_type_are_not_listed(String referenceType) throws Throwable {
        assertTrue(!this.thereAreVisibleReferencesOfType(referenceType));
    }
    
    private void addReference(String referenceType, boolean shouldContainText, String text) {
        driver.get(baseUrl + "/new");
        this.selectReferenceTypeForInputForm(referenceType);

        switch (referenceType) {
            case "article":
                this.setDefaultRequiredFieldsForArticle(shouldContainText, text);
                break;
            case "book":
                this.setDefaultRequiredFieldsForBook(shouldContainText, text);
                break;
            case "inproceedings":
                this.setDefaultRequiredFieldsForInproceedings(shouldContainText, text);
                break;
            default:
                break;
        }
        
        this.submitReferenceForm(referenceType);
    }

    private void setDefaultRequiredFieldsForArticle(boolean shouldContainTheText, String text) {

        if (shouldContainTheText) {
            giveValueToField("key", "article-key");
            giveValueToField("author", "article-author");
            giveValueToField("title" + text, "article-title");
            giveValueToField("journal", "article-journal");
            giveValueToField("volume", "article-volume");
            giveValueToField("year", "article-year");
        } else {
            String stringWithoutGivenText = this.createStringNotContaining(text);

            giveValueToField(stringWithoutGivenText, "article-key");
            giveValueToField(stringWithoutGivenText, "article-author");
            giveValueToField(stringWithoutGivenText, "article-title");
            giveValueToField(stringWithoutGivenText, "article-journal");
            giveValueToField(stringWithoutGivenText, "article-volume");
            giveValueToField(stringWithoutGivenText, "article-year");
        }

    }

    private void setDefaultRequiredFieldsForBook(boolean shouldContainTheText, String text) {

        if (shouldContainTheText) {
            giveValueToField("key", "book-key");
            giveValueToField("author", "book-author");
            giveValueToField("title" + text, "book-title");
            giveValueToField("publisher", "book-publisher");
            giveValueToField("year", "book-year");
        } else {
            String stringWithoutGivenText = this.createStringNotContaining(text);

            giveValueToField(stringWithoutGivenText, "book-key");
            giveValueToField(stringWithoutGivenText, "book-author");
            giveValueToField(stringWithoutGivenText, "book-title");
            giveValueToField(stringWithoutGivenText, "book-publisher");
            giveValueToField(stringWithoutGivenText, "book-year");
        }
    }

    private void setDefaultRequiredFieldsForInproceedings(boolean shouldContainTheText, String text) {

        if (shouldContainTheText) {
            giveValueToField("key", "inproceedings-key");
            giveValueToField("author", "inproceedings-author");
            giveValueToField("title" + text, "inproceedings-title");
            giveValueToField("booktitle", "inproceedings-booktitle");
            giveValueToField("year", "inproceedings-year");
        } else {
            String stringWithoutGivenText = this.createStringNotContaining(text);

            giveValueToField(stringWithoutGivenText, "inproceedings-key");
            giveValueToField(stringWithoutGivenText, "inproceedings-author");
            giveValueToField(stringWithoutGivenText, "inproceedings-title");
            giveValueToField(stringWithoutGivenText, "inproceedings-booktitle");
            giveValueToField(stringWithoutGivenText, "inproceedings-year");
        }
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
    
    private void submitReferenceForm(String referenceType) {
        WebElement element = driver.findElement(By.id("add-" + referenceType));
        element.click();
    }

    private String createStringNotContaining(String text) {
        return text.equals("q") ? "a" : "q";
    }

    private boolean thereAreVisibleReferencesOfType(String referenceType) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object response = js.executeScript(this.javascriptStringForVisibleReferencetypeQuery(referenceType));
        return response.toString().equals("true");
    }

    private String javascriptStringForVisibleReferencetypeQuery(String referenceType) {
        return "return (function () {"
                + "var referencesOfTheRightType = document.getElementsByClassName('" + referenceType + "');"
                + "for(var i = 0; i < referencesOfTheRightType.length; i += 1) {"
                + "if(referencesOfTheRightType[i].style.display !== \"none\") {"
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
