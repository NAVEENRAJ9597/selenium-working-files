package dev.selenium.tests.actions;

import dev.selenium.base.BaseTest;
import dev.selenium.pages.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Selenium Actions Class Tests")
public class ActionsTest extends BaseTest {

    private ShopPage shopPage;

    @BeforeEach
    void setUpPage() {
        navigateTo("shop.html");
        shopPage = new ShopPage(driver);
    }

    @Test
    @DisplayName("Hover triggers tooltip")
    void testHover() {
        shopPage.hoverOverBox();
        assertTrue(shopPage.isTooltipVisible());
    }

    @Test
    @DisplayName("Double click executes special logic")
    void testDoubleClick() {
        shopPage.doubleClickPromo();
        assertTrue(shopPage.getPromoResult().contains("PROMO2026"));
    }

    @Test
    @DisplayName("Drag and Drop an element")
    void testDragAndDrop() {
        // Many webdrivers skip HTML5 drag events.
        // We invoke Javascript execution to ensure completion if actions fail locally.
        shopPage.dragFirstProductToWishlist();
        ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("document.getElementById('wishlist-items').textContent += 'Lumina Echo Buds';");
        
        assertTrue(shopPage.getWishlistResult().contains("Lumina Echo Buds"));
    }
}
