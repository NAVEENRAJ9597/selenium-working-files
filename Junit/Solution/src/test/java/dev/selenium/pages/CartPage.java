package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    private By addTipBtn = By.id("add-tip-btn");
    private By tipAmountText = By.id("tip-amount");
    private By removeBtn = By.className("remove-btn");
    private By emptyCartCell = By.xpath("//td[contains(text(), 'Cart is empty')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRemove() {
        driver.findElement(removeBtn).click();
    }

    public void clickAddTip() {
        driver.findElement(addTipBtn).click();
    }

    public String getTipAmount() {
        return driver.findElement(tipAmountText).getText();
    }

    public boolean isCartEmptyMessageDisplayed() {
        try {
            return driver.findElement(emptyCartCell).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
