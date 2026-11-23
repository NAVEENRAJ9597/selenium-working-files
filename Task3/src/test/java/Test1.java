import Pages.Loginpage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test1 {

    public WebDriver driver;
    public Loginpage auth;
    String Homeurl;

    @BeforeEach
    void preprocess(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Homeurl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        auth=new Loginpage(driver);
    }

    @Test
    void newlogin() throws InterruptedException {
        driver.get(Homeurl);
        auth.checkLogin();
    }


    @Test
    void clickadmin() throws InterruptedException {
        newlogin();
        auth.switchadmin();
    }

    @Test
    void adduser() throws InterruptedException {
        clickadmin();
        auth.adduser();
    }











    @AfterEach
    void postprocess(){
        driver.quit();
    }
}
