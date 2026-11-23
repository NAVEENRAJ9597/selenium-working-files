package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    public WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterEmail() {
        driver.findElement(By.className("form-input")).sendKeys("naveen@gmail.com");
    }

    public void enterPass() {
        driver.findElement(By.id("password")).sendKeys("Nave123");
    }

    public void Sumbit() {
        driver.findElement(By.id("login-btn")).click();
    }

    public void addcart() {
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.className("product-title"));
        driver.findElement(By.className("btn-primary")).click();
    }

    public void Viewcart() {
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.linkText("Cart")).click();
    }

    public void addtips() {
        driver.findElement(By.id("add-tip-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("10");


        alert.accept();
    }

    public void addcheckout()

    {

        driver.findElement(By.id("checkout-btn")).click();


//        driver.findElement(By.id("email")).sendKeys("Nadhah@gmail.com");


        WebElement iframe = driver.findElement(By.id("payment-iframe"));
        driver.switchTo().frame(iframe);


        driver.findElement(By.id("cc-number")).sendKeys("1234567891234567");
        driver.findElement(By.id("cc-exp")).sendKeys("04/2026");
        driver.findElement(By.id("cc-cvc")).sendKeys("205");


        driver.findElement(By.id("validate-btn")).click();


        driver.switchTo().defaultContent();


        driver.findElement(By.className("place-order-btn")).click();
    }
}






