import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Simple setup to navigate to a login page
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    // 1. Define the DataProvider
   @DataProvider(name="logindetails")
   public Object[][] getData(){
        return new Object[][]{
                {"user1","pass12"},
                {"user2","pass123"}
        };
   }

    // 2. Link the DataProvider to the Test Method
   @Test(dataProvider = "logindetails")
    public void testLogin(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // Add assertions here to verify successful login
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}