import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Locaters2 {

    public WebDriver driver;

    @BeforeEach
    void preprocess() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "#my-text-id",
            ".form-control",
            "input[name='my-password']"
    })
    public void testCssSelectors(String cssLocator) {
        WebElement element = driver.findElement(By.cssSelector(cssLocator));
        assertTrue(element.isDisplayed());

        System.out.println("\n\n Locator: " + cssLocator);
        System.out.println("Is Displayed: " + element.isDisplayed());
        System.out.println("Tag Name: " + element.getTagName());
        System.out.println("ID Attribute: " + element.getAttribute("id"));
        System.out.println("Name Attribute: " + element.getAttribute("name"));
        System.out.println("Value Attribute: " + element.getAttribute("value"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//input[@id='my-text-id']",
            "//button[contains(text(), 'Submit')]",
            "//input[@type='password' and @name='my-password']"
    })
    public void testXPathLocators(String xpathLocator) {
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        assertTrue(element.isDisplayed());

        System.out.println("\n\n Locator: " + xpathLocator);
        System.out.println("Is Displayed: " + element.isDisplayed());
        System.out.println(" Tag Name: " + element.getTagName());
        System.out.println(" Visible Text: " + element.getText());
        System.out.println(" Value Attribute: " + element.getAttribute("value"));
    }

    @AfterEach
    void postprocess() {
        driver.quit();
    }
}