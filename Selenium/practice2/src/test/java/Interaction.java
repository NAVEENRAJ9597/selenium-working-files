import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Interaction {

    public WebDriver driver;

    @BeforeEach
    void preprocess() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void TextInputInteractions() throws InterruptedException {
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        Thread.sleep(5000);
        textInput.sendKeys("Initial Input");

        assertEquals("Initial Input", textInput.getAttribute("value"));
        Thread.sleep(5000);

        textInput.clear();
        assertEquals("", textInput.getAttribute("value"));
        Thread.sleep(5000);
    }

    @Test
    public void CheckboxAndRadioInteractions() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("my-check-2"));
        Thread.sleep(5000);
        checkbox.click();

        assertTrue(checkbox.isSelected());
        Thread.sleep(5000);

        WebElement radio = driver.findElement(By.id("my-radio-2"));
        radio.click();
        assertTrue(radio.isSelected());
        Thread.sleep(5000);
    }

    @Test
    public void DropdownSelection() throws InterruptedException {
        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(selectElement);
        Thread.sleep(5000);
        System.out.println("Selecting option by visible text: 'Two'");
        dropdown.selectByVisibleText("Two");
        assertEquals("2", dropdown.getFirstSelectedOption().getAttribute("value"));
        Thread.sleep(5000);

        System.out.println("Selecting option by value: '3'");
        dropdown.selectByValue("3");
        assertEquals("Three", dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);

        System.out.println("Selecting option by index: 1");
        dropdown.selectByIndex(1);
        assertEquals("One", dropdown.getFirstSelectedOption().getText());
        Thread.sleep(5000);

    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        WebElement form = driver.findElement(By.tagName("form"));
        Thread.sleep(5000);
        form.submit();
        assertTrue(driver.getCurrentUrl().contains("submitted"));
        Thread.sleep(5000);
    }

    @AfterEach
    void postprocess() {
        driver.quit();
    }
}