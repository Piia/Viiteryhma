
package viiteryhma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tester {

    
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/tiera/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080/");
        
        sleep(2);
        WebElement element = driver.findElement(By.id("article-author"));
        element.sendKeys("asdas");
        element = driver.findElement(By.id("article-journal"));
        element.sendKeys("asdasd");
        element = driver.findElement(By.id("article-volume"));
        element.sendKeys("asdas");
        element = driver.findElement(By.id("article-year"));
        element.sendKeys("asdasd");
        element.submit();
        sleep(2);
        element = driver.findElement(By.linkText("Add a reference"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("Export references"));
        element.click();
        sleep(2);
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

}
