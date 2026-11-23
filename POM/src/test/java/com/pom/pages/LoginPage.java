package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("loginSubmit");
    private By emailError = By.id("emailError");
    private By passwordError = By.id("passwordError");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public HomePage loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return new HomePage(driver);
    }

    public boolean isEmailErrorDisplayed() {
        return driver.findElement(emailError).isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }
}