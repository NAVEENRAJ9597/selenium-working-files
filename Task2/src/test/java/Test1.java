import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Loginpage;

public class Test1 {
    public WebDriver driver;
    String Login;
    String Home;
    public Loginpage users;

    @BeforeEach
    void preprocess(){
        driver=new ChromeDriver();
        Home="https://parabank.parasoft.com/parabank/index.htm;jsessionid=77945BE47BA7E4C70C1D1F7C97977896";
        users=new Loginpage(driver);
    }


    @Test
    void newregister() throws InterruptedException {
        driver.get(Home);
        users.Register();
    }

    @Test
    void checklogin() throws InterruptedException {
        driver.get(Home);
        users.checklogin();
    }
    @Test
    void addnewaccount() throws InterruptedException {
        newregister();
        checklogin();

        users.opennewaccount();
    }

    @AfterEach
    void postprocess(){
     driver.quit();
    }
}
