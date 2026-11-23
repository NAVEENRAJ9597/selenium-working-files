package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    // Using PageFactory here to satisfy the "Page Factory" concept
    @FindBy(id = "terms-link")
    private WebElement termsLink;

    @FindBy(id = "help-popup-btn")
    private WebElement helpPopupBtn;

    @FindBy(id = "payment-iframe")
    private WebElement paymentIframe;

    @FindBy(id = "cc-number")
    private WebElement ccNumberInput;

    @FindBy(id = "validate-btn")
    private WebElement validateBtn;

    @FindBy(id = "payment-status")
    private WebElement paymentStatusText;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTermsLink() {
        termsLink.click();
    }

    public void clickHelpPopup() {
        helpPopupBtn.click();
    }

    public void switchToPaymentFrame() {
        driver.switchTo().frame(paymentIframe);
    }

    public void enterCreditCard(String cc) {
        ccNumberInput.sendKeys(cc);
    }

    public void validateCard() {
        validateBtn.click();
    }

    public String getPaymentStatus() {
        return paymentStatusText.getText();
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }
}
