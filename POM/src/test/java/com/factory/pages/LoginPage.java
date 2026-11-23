package com.factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "loginSubmit")
    private WebElement submitButton;

    @FindBy(id = "emailError")
    private WebElement emailError;

    @FindBy(id = "passwordError")
    private WebElement passwordError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public HomePage loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return new HomePage(driver);
    }

    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }
}