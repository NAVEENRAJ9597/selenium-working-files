package dev.selenium.tests.windows;

import dev.selenium.base.BaseTest;
import dev.selenium.pages.CheckoutPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Multiple Windows Tests")
public class WindowsTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeEach
    void setUpPage() {
        navigateTo("checkout.html");
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    @DisplayName("Switch to new tab and return")
    void testNewTabSwitch() {
        String originalHandle = driver.getWindowHandle();
        checkoutPage.clickTermsLink();
        
        // Wait for 2 windows
        wait.until(d -> d.getWindowHandles().size() == 2);
        
        for (String handle : driver.getWindowHandles()) {
            if(!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        String newTitle = driver.getTitle();
        assertEquals("Terms & Conditions", driver.findElement(org.openqa.selenium.By.id("terms-title")).getText());
        
        driver.close(); // Close the tab
        driver.switchTo().window(originalHandle); // Back to main
    }
}
