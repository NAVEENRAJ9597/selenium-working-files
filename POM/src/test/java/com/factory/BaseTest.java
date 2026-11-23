package com.factory;

import com.factory.pages.HomePage;
import com.factory.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String loginUrl;
    private String homeUrl;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        loginUrl = "file:///F:/at/sel5/src/main/resources/login.html";
        homeUrl = "file:///F:/at/sel5/src/main/resources/home.html";
    }

    @Test
    public void testValidLoginRouting() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("user@example.com", "secure123");

        wait.until(ExpectedConditions.urlContains("home.html"));
        assertTrue(driver.getCurrentUrl().contains("home.html"));
    }

    @Test
    public void testInvalidEmailValidation() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("invalidemail");
        loginPage.enterPassword("secure123");
        loginPage.clickSubmit();

        assertFalse(loginPage.isEmailErrorDisplayed());
    }

    @Test
    public void testEmptyPasswordValidation() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("user@example.com");
        loginPage.clickSubmit();

        assertTrue(loginPage.isPasswordErrorDisplayed());
    }

    @Test
    public void testUnauthenticatedAccessRedirect() {
        driver.get(homeUrl);

        wait.until(ExpectedConditions.urlContains("login.html"));
        assertTrue(driver.getCurrentUrl().contains("login.html"));
    }

    @Test
    public void testAddToCartFunctionality() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginAs("test@store.com", "pass");

        wait.until(ExpectedConditions.urlContains("home.html"));

        homePage.clickAddToCartButtonAtIndex(0);
        homePage.clickAddToCartButtonAtIndex(1);

        assertEquals("2", homePage.getCartItemCount());
    }

    @Test
    public void testLogoutFunctionality() {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.loginAs("test@store.com", "pass");

        wait.until(ExpectedConditions.urlContains("home.html"));

        homePage.clickLogout();

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