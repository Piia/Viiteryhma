
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



public class Stepdefs {
    
    
    
//    Elikkä tähän tiedostoon kirjoitetaan featureiden sisältämien scenarioiden
//    stepit, eli testien suorittaminen
//    Tähän kopsasin laskareista esimerkin stepeistä. Lopussa alimpana Tieran koodit.

    private WebDriver driver;
    private String baseUrl;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:4567";
    }
    
//    @Given("^login is selected$")
//    public void login_selected() throws Throwable {
//        driver.get(baseUrl);
//        WebElement element = driver.findElement(By.linkText("login"));       
//        element.click();          
//    } 
//    
//    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
//    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
//        logInWith(username, password);
//    }
//    
//    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
//    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
//        logInWith(username, password);
//    }
//    
//    @Then("^user is logged in$")
//    public void user_is_logged_in() throws Throwable {
//        pageHasContent("Ohtu Application main page");
//    }
//    
//    @Then("^user is not logged in and error message is given$")
//    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
//        pageHasContent("invalid username or password");
//        pageHasContent("Give your credentials to login");
//    }     
//    
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
//        
//    /* helper methods */
// 
//    private void pageHasContent(String content) {
//        assertTrue(driver.getPageSource().contains(content));
//    }
//        
//    private void logInWith(String username, String password) {
//        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
//        WebElement element = driver.findElement(By.name("username"));
//        element.sendKeys(username);
//        element = driver.findElement(By.name("password"));
//        element.sendKeys(password);
//        element = driver.findElement(By.name("login"));
//        element.submit();  
//    } 
    
    
    
    
    
    
    
    
    
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
