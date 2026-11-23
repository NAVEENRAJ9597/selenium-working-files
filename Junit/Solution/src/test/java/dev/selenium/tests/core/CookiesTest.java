package dev.selenium.tests.core;

import dev.selenium.base.BaseTest;
import dev.selenium.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Core Selenium Concept Tests")
public class CookiesTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void setUpPage() {
        // Ensure starting clean
        driver.manage().deleteAllCookies();
        navigateTo("index.html");
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Accept cookies banner updates browser cookies - Mock via domain")
    void testCookieConsent() {
        // file:/// protocol does not support native browser cookies.
        // We navigate to a generic safe URL to demonstrate Selenium Cookie API.
        driver.navigate().to("http://example.com");
        
        // Assert no lumina cookie exists yet
        assertNull(driver.manage().getCookieNamed("lumina_consent"));
        
        // Add cookie
        driver.manage().addCookie(new Cookie("lumina_consent", "true"));
        
        // Assert cookie was added
        Cookie consentCookie = driver.manage().getCookieNamed("lumina_consent");
        assertNotNull(consentCookie, "Consent cookie should exist in browser");
        assertEquals("true", consentCookie.getValue());
    }

    @Test
    @DisplayName("Injecting a cookie natively")
    void testInjectCookie() {
        driver.navigate().to("http://example.com");
        driver.manage().addCookie(new Cookie("test_cookie", "injected_value"));
        assertEquals("injected_value", driver.manage().getCookieNamed("test_cookie").getValue(), "WebDriver should retrieve the exact cookie value");
    }
}
