import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;

import java.time.Duration;



public class Task2 {
    public WebDriver driver;
    String loginUrl;
    String homeUrl;
    String ShopeUrl;
    public Homepage user;


    @BeforeEach
    void preprocess() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = new Homepage(driver);

        loginUrl = "C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/login.html";
        homeUrl = "C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/index.html";
        ShopeUrl="C:/Users/nraj6/Desktop/Selenium working files/intellij working files/Tasks/src/main/resources/shop.html";
    }
    @Test
    public void Login() throws InterruptedException {
        driver.get(loginUrl);

        user.EnterEmail();
        Thread.sleep(2000);
        user.enterPass();
       user.Sumbit();
    }

    @Test
    void addcart() throws InterruptedException {
        Login();

        user.addcart();
        Thread.sleep(3000);

    }

    @Test
    void Viewcart() throws InterruptedException {
        Login();

        user.Viewcart();
        Thread.sleep(2000);
    }
    @Disabled
    @Test
    void addtips() throws InterruptedException {
        Login();
        user.Viewcart();
        user.addtips();
        Thread.sleep(5000);
    }

    @Test
    void addcheckout() throws InterruptedException {
        Login();


        Viewcart();
        Thread.sleep(2000);
        user.addcheckout();
    }

    @AfterEach
    void postprocess(){
        driver.quit();
    }


}
