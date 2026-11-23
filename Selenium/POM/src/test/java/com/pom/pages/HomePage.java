package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    private By addToCartButtons = By.cssSelector(".add-to-cart-btn");
    private By cartCountBadge = By.id("cartCount");
    private By logoutButton = By.id("logoutBtn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButtonAtIndex(int index) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(index).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartCountBadge).getText();
    }

    public LoginPage clickLogout() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}