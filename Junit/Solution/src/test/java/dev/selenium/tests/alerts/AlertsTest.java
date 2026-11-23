package dev.selenium.tests.alerts;

import dev.selenium.base.BaseTest;
import dev.selenium.pages.CartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Alerts & Popups Tests")
public class AlertsTest extends BaseTest {

    private CartPage cartPage;

    @BeforeEach
    void setUpPage() {
        navigateTo("cart.html");
        cartPage = new CartPage(driver);
    }

    @Test
    @DisplayName("Dismiss native JS Confirm dialog")
    void testDismissConfirm() {
        cartPage.clickRemove();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        // Item is not removed
        assertTrue(!cartPage.isCartEmptyMessageDisplayed());
    }

    @Test
    @DisplayName("Handle native JS Prompt dialog")
    void testPromptDialog() {
        cartPage.clickAddTip();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("15");
        alert.accept();
        assertTrue(cartPage.getTipAmount().contains("15"));
    }
}
