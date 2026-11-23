import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Locaters1 {

    public WebDriver driver;

    @BeforeEach
    void preprocess() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    void checkTitle() {
        String title = driver.getTitle();
        System.out.println("Title: "+title);
        assertEquals("Web form", title);
    }

    @Test
    void checkId() {
        WebElement text = driver.findElement(By.id("my-text-id"));
        String content = text.getText();
        System.out.println("ID: "+content);
    }

    @Test
    void checkClass() {
        WebElement text = driver.findElement(By.className("form-control"));
        String content = text.getAttribute("type");
        System.out.println("First Class: "+content);
    }

    @Test
    void checkClassNames() {
        List<WebElement> elements = driver.findElements(By.className("form-control"));
        for  (WebElement ele : elements) {
            String content = ele.getAttribute("type");
            System.out.println("Class content: "+content);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "html", "head", "body" })
    void checkContent(String tag) {
        WebElement element = driver.findElement(By.tagName(tag));
        String content = element.getAttribute("innerHTML");
        System.out.println("Content: "+content);
    }

    @AfterEach
    void postprocess() {
        driver.quit();
    }
}
