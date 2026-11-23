package com.factory.pages;

import com.pom.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = ".add-to-cart-btn")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "cartCount")
    private WebElement cartCountBadge;

    @FindBy(id = "logoutBtn")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButtonAtIndex(int index) {
        addToCartButtons.get(index).click();
    }

    public String getCartItemCount() {
        return cartCountBadge.getText();
    }

    public LoginPage clickLogout() {
        logoutButton.click();
        return new LoginPage(driver);
    }
}