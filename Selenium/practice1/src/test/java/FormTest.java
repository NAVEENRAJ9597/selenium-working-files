import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest {

    @Test
    void checkTitle() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String title = driver.getTitle();
        System.out.println("Title: "+title);

        assertEquals("Web form", title);

        driver.quit();
    }

    @Test
    void checkContent() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web-form.html");

        WebElement element = driver.findElement(By.tagName("html"));
        String content = element.getAttribute("innerHTML");
        System.out.println("Content: "+content);

        driver.quit();
    }

}
