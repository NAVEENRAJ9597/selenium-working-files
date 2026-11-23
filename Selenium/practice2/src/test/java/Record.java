import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Record {

    public WebDriver driver;

    @BeforeEach
    void preprocess() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void testElementScreenshot() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement form = driver.findElement(By.tagName("form"));

        File screenshot = form.getScreenshotAs(OutputType.FILE);
        assertTrue(screenshot.exists());
        assertTrue(screenshot.length() > 0);
    }

    @Test
    public void testPagePrintToPdf() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        PrintOptions printOptions = new PrintOptions();
        printOptions.setBackground(true);

        Pdf pdf = ((PrintsPage) driver).print(printOptions);

        String base64EncodedPdf = pdf.getContent();
        assertNotNull(base64EncodedPdf);
        assertTrue(base64EncodedPdf.length() > 0);
    }

    @AfterEach
    void postprocess() {
        driver.quit();
    }
}