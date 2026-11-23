package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShopPage {
    private WebDriver driver;
    private Actions actions;

    private By hoverBox = By.id("hover-box");
    private By tooltipText = By.id("hover-tooltip");
    private By doubleClickBox = By.id("double-click-box");
    private By promoResult = By.id("promo-result");
    private By firstProduct = By.cssSelector(".product-card");
    private By dropzone = By.id("wishlist-dropzone");
    private By wishlistItems = By.id("wishlist-items");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void hoverOverBox() {
        WebElement box = driver.findElement(hoverBox);
        actions.moveToElement(box).perform();
    }

    public boolean isTooltipVisible() {
        return driver.findElement(tooltipText).isDisplayed();
    }

    public void doubleClickPromo() {
        WebElement box = driver.findElement(doubleClickBox);
        actions.doubleClick(box).perform();
    }

    public String getPromoResult() {
        return driver.findElement(promoResult).getText();
    }

    public void dragFirstProductToWishlist() {
        WebElement src = driver.findElement(firstProduct);
        WebElement target = driver.findElement(dropzone);
        actions.dragAndDrop(src, target).perform();
    }

    public String getWishlistResult() {
        return driver.findElement(wishlistItems).getText();
    }
}
