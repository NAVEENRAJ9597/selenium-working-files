package dev.selenium.tests.frames;

import dev.selenium.base.BaseTest;
import dev.selenium.pages.CheckoutPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Frames & iFrames Tests")
public class FramesTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeEach
    void setUpPage() {
        navigateTo("checkout.html");
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    @DisplayName("Interact with Payment iframe Elements")
    void testIframeInteraction() {
        checkoutPage.switchToPaymentFrame();
        checkoutPage.enterCreditCard("1111222233334444");
        checkoutPage.validateCard();
        assertTrue(checkoutPage.getPaymentStatus().contains("Validated"));
        checkoutPage.switchToDefault();
    }
}
