import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IndividualTest {

    private WebDriver driver;
    private String loginUrl;
    private String homeUrl;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginUrl = "file:///F:/at/sel5/src/main/resources/login.html";
        homeUrl = "file:///F:/at/sel5/src/main/resources/home.html";
    }

    @Test
    public void testValidLoginRouting() {
        driver.get(loginUrl);
        driver.findElement(By.id("email")).sendKeys("user@example.com");
        driver.findElement(By.id("password")).sendKeys("secure123");
        driver.findElement(By.id("loginSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("home.html"));

        assertTrue(driver.getCurrentUrl().contains("home.html"));
    }

    @Test
    public void testInvalidEmailValidation() {
        driver.get(loginUrl);
        driver.findElement(By.id("email")).sendKeys("invalidemail");
        driver.findElement(By.id("password")).sendKeys("secure123");
        driver.findElement(By.id("loginSubmit")).click();

        WebElement emailError = driver.findElement(By.id("emailError"));
        assertFalse(emailError.isDisplayed());
    }

    @Test
    public void testEmptyPasswordValidation() {
        driver.get(loginUrl);
        driver.findElement(By.id("email")).sendKeys("user@example.com");
        driver.findElement(By.id("loginSubmit")).click();

        WebElement passwordError = driver.findElement(By.id("passwordError"));
        assertTrue(passwordError.isDisplayed());
    }

    @Test
    public void testUnauthenticatedAccessRedirect() {
        driver.get(homeUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("login.html"));

        assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    public void testAddToCartFunctionality() {
        driver.get(loginUrl);
        driver.findElement(By.id("email")).sendKeys("test@store.com");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("loginSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("home.html"));

        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".add-to-cart-btn"));
        addToCartButtons.get(0).click();
        addToCartButtons.get(1).click();

        WebElement cartCount = driver.findElement(By.id("cartCount"));
        assertEquals("2", cartCount.getText());
    }

    @Test
    public void testLogoutFunctionality() {
        driver.get(loginUrl);
        driver.findElement(By.id("email")).sendKeys("test@store.com");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("loginSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("home.html"));

        driver.findElement(By.id("logoutBtn")).click();

        wait.until(ExpectedConditions.urlContains("login.html"));
        assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}