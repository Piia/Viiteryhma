
package viiteryhma;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.bibTex.References;
import java.io.File;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Stepdefs {
    

    private WebDriver driver;
    private String baseUrl;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080";
    }
    
    @Given("^add reference of type \"([^\"]*)\" is selected$")
    public void add_reference(String referenceType) throws Throwable {
        driver.get(baseUrl + "/new");
        WebElement element = driver.findElement(By.id("reference-type"));
        Select select = new Select(element);
        select.selectByValue(referenceType);        
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
        giveValueToField(booktitle, "inproceedings-publisher");
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
    
    @Then("^reference is added$")
    public void reference_is_added() throws Throwable {
        assertTrue(driver.getPageSource().contains("Reference added successfully!"));
    }
    
    @Then("^reference is not added$")
    public void reference_is_not_added() throws Throwable {
        assertTrue(!driver.getPageSource().contains("Reference added successfully!"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    
    private void giveValueToField(String value, String field) {
        WebElement element = driver.findElement(By.id(field));
        element.sendKeys(value);
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
