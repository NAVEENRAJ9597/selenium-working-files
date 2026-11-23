package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Instant;

public class Loginpage {
    public WebDriver driver;


    public Loginpage(WebDriver driver) {
        this.driver=driver;
    }

    public void Register() throws InterruptedException {
     driver.findElement(By.linkText("Register")).click();
     driver.findElement(By.id("customer.firstName")).sendKeys("dhoni");

        driver.findElement(By.id("customer.lastName")).sendKeys("s");

        driver.findElement(By.id("customer.address.street")).sendKeys("22 str street,dhubai.");


        driver.findElement(By.id("customer.address.city")).sendKeys("dhubai");


        driver.findElement(By.id("customer.address.state")).sendKeys("Abudhabi");


        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");

        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");

        driver.findElement(By.id("customer.ssn")).sendKeys("5425136");

        driver.findElement(By.id("customer.username")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("customer.password")).sendKeys("abc123");

        driver.findElement(By.id("repeatedPassword")).sendKeys("abc123");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

    }
    public void  checklogin() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Abc@567");
        Thread.sleep(3000);
        // syntax for xpath find  == //tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(3000);

    }

//    public void switchtohome(){
//
//        Alert alert = driver.switchTo().alert();
//
//        alert.dismiss();
//    }


    public void opennewaccount() throws InterruptedException {
        driver.findElement(By.linkText("Open New Account")).click();
        WebElement element=driver.findElement(By.id("type"));
        Select dropdown=new Select(element);

        Thread.sleep(2000);
        dropdown.selectByValue("1");

        WebElement element1=driver.findElement(By.id("fromAccountId"));
        Select dropdown1=new Select(element1);

        Thread.sleep(2000);
        dropdown1.selectByValue("13788");

        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
    }
}
