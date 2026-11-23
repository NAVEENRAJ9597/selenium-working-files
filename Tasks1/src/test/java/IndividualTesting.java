import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class IndividualTesting {
   public WebDriver driver;
   String loginUrl;
   String homeUrl;
   String ShopeUrl;
    WebDriverWait wait;

   @BeforeEach
    void preprocess() throws InterruptedException {
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        loginUrl = "C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/login.html";
        homeUrl = "C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/index.html";
        ShopeUrl="C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/shop.html";
   }

   @Test
   public void TestvalidLogin() throws InterruptedException {
       driver.get(loginUrl);
       driver.findElement(By.id("email")).sendKeys("naveen@gmail.com");

       driver.findElement(By.id("password")).sendKeys("Nave12439");

       driver.findElement(By.id("login-btn")).click();

       Thread.sleep(3000);
   }
    @Disabled
   @Test
   public void TestInvalidLogin() throws InterruptedException {
       driver.get(loginUrl);
       driver.findElement(By.id("email")).sendKeys("ahahh@gamil.com");
       driver.findElement(By.id("password")).sendKeys("123aadj");
       driver.findElement(By.id("login-btn")).click();
       Thread.sleep(3000);
       WebElement emailerror = driver.findElement(By.id("login-error"));
       assertTrue(emailerror.isDisplayed());
   }

   @Test
   public void viewshop() throws InterruptedException {
       driver.get(homeUrl);
       Thread.sleep(2000);
       driver.findElement(By.id("email")).sendKeys("naveen@gmail.com");

       driver.findElement(By.id("password")).sendKeys("Nave123");

       driver.findElement(By.id("login-btn")).click();


        driver.findElement(By.className("btn-primary")).click();
       driver.findElement(By.className("product-title"));
       driver.findElement(By.className("btn-primary")).click();
       Thread.sleep(3000);

   }






   @AfterEach
    void postprocess(){
       driver.quit();
   }
}
