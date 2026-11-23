import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {

    WebDriver driver;

    @BeforeEach
    void preprocess() {

        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    void checkTitle() {

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertEquals("Web form", title);
    }

    @ParameterizedTest
    @ValueSource(strings = { "html", "head", "body" })
    void checkContent(String tag) {

        WebElement element = driver.findElement(By.tagName(tag));
        String content = element.getAttribute("innerHTML");
        System.out.println("Content: " + content);
    }

    @AfterEach
    void postprocess() {

        if (driver != null) {
            driver.quit();
        }
    }
}