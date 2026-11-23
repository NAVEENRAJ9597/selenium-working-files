package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By acceptCookieBtn = By.id("accept-cookies");
    private By cookieBanner = By.id("cookie-banner");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isCookieBannerDisplayed() {
        try {
            return driver.findElement(cookieBanner).isDisplayed();
        } catch(Exception e) {
            return false;
        }
    }

    public void clickAcceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookieBtn)).click();
    }
}
