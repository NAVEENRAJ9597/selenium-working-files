import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test2 {

    public WebDriver driver;

    @BeforeEach
    void preprocess(){
         driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }
    @Test
    void checkTitle(){

        String title=driver.getTitle();
        System.out.println("Title: "+title);
        assertEquals("Web form",title);
    }

    @Test
    void  checkContent(){

        WebElement element = driver.findElement(By.tagName("html"));
        String content = element.getAttribute("innerHTML");
        System.out.println("Content:"+ content);

    }

    @Test
    void checkBody(){

        WebElement element = driver.findElement(By.tagName("body"));
        String body = element.getAttribute("innerHTML");
        System.out.println("Body:"+ body);
    }

    @AfterEach
    void postprocess(){
        driver.quit();
    }

}