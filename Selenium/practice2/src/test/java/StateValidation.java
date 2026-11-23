import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateValidation {

    public WebDriver driver;

    @BeforeEach
    void preprocess() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Disabled
    @Test
    public void testVisibilityState() {
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        assertTrue(textInput.isDisplayed());

        WebElement hiddenInput = driver.findElement(By.name("my-hidden"));
        assertFalse(hiddenInput.isDisplayed());
    }

    @Test
    public void testInteractabilityState() {
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        assertTrue(textInput.isEnabled());

        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        assertFalse(disabledInput.isEnabled());
    }

    @Test
    public void testSelectionState() {
        WebElement defaultCheckbox = driver.findElement(By.id("my-check-1"));
        assertTrue(defaultCheckbox.isSelected());

        WebElement secondaryCheckbox = driver.findElement(By.id("my-check-2"));
        assertFalse(secondaryCheckbox.isSelected());
    }

    @AfterEach
    void postprocess() {
        driver.quit();
    }
}