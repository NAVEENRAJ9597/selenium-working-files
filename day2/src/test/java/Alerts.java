import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {

    @Disabled
    @Test
    void testAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");

        WebElement element = driver.findElement(By.id("prompt"));
        element.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("This is simple text");

        Thread.sleep(3000);

        String text = alert.getText();
        System.out.println("Text: " + text);

        Thread.sleep(3000);

        alert.accept();

        Thread.sleep(2000);

        driver.quit();
    }


    @Test
    void testIFrame() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");



        WebElement element = driver.findElement(By.id("alertInFrame"));
        String content =  element.getText();
        System.out.println("Content: " + content);


        driver.switchTo().defaultContent();

        driver.quit();
    }

}
