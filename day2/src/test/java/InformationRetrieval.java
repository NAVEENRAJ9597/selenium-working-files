import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InformationRetrieval {

    public WebDriver driver;

    @BeforeEach
    void preprocess() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void TextAndAttributes() throws InterruptedException {
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println("Header Text: " + header.getText());
        assertEquals("Web form", header.getText());
        Thread.sleep(2000);

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        System.out.println("Input ID Attribute: " + textInput.getAttribute("id"));
        System.out.println("Input Type Attribute: " + textInput.getAttribute("type"));
        assertEquals("my-text-id", textInput.getAttribute("id"));
        assertEquals("text", textInput.getAttribute("type"));
        Thread.sleep(2000);
    }

    @Test
    public void ComputedCssAndTagData() throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector(".btn-outline-primary"));
        System.out.println("Button Tag Name: " + button.getTagName());
        assertEquals("button", button.getTagName());
        Thread.sleep(2000);

        System.out.println("Button Background Color: " + button.getCssValue("background-color"));
        System.out.println("Button Font Family: " + button.getCssValue("font-family"));
        assertNotNull(button.getCssValue("background-color"));
        assertNotNull(button.getCssValue("font-family"));
        Thread.sleep(2000);
    }

    @Test
    public void DimensionalAndSpatialData() throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector(".btn-outline-primary"));

        Dimension size = button.getSize();
        System.out.println("Element Height: " + size.getHeight() + ", Width: " + size.getWidth());
        assertTrue(size.getHeight() > 0);
        assertTrue(size.getWidth() > 0);
        Thread.sleep(2000);

        Point location = button.getLocation();
        System.out.println("Element X Coordinate: " + location.getX() + ", Y Coordinate: " + location.getY());
        assertTrue(location.getX() > 0);
        assertTrue(location.getY() > 0);
        Thread.sleep(2000);

        Rectangle rect = button.getRect();
        System.out.println("Rectangle Data -> X: " + rect.getX() + ", Y: " + rect.getY() + ", Height: " + rect.getHeight() + ", Width: " + rect.getWidth());
        Thread.sleep(2000);
    }

    @AfterEach
    void postprocess() throws InterruptedException {
        driver.quit();
    }
}