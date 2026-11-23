package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Loginpage {

    public WebDriver driver;

    public Loginpage(WebDriver driver){
        this.driver=driver;
    }


    public void checkLogin() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("Admin");



        driver.findElement(By.name("password")).sendKeys("admin123");


        driver.findElement(By.className("oxd-button")).click();

    }

    public void switchadmin() throws InterruptedException {
        driver.findElement(By.partialLinkText("Admin")).click();
        Thread.sleep(5000);
    }

    public void adduser() throws InterruptedException {
        driver.findElement(By.className("oxd-button--medium")).click();
        Thread.sleep(4000);

//        WebElement element=driver.findElement(By.className("oxd-select-text-input"));
//        Select dropdown=new Select(element);
//
//        dropdown.selectByValue("Admin");



    }
}
