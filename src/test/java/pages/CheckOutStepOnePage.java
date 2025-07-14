package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage {

    public final By TITLE = By.xpath("//span[text()='Checkout: Your Information']");
    public final By BUTTON_CART = By.xpath("//a[contains(@class,'shopping_cart_link')]");
    public final By BUTTON_CANCEL = By.xpath("//button[contains(@class,'btn btn_secondary back btn_medium cart_cancel_link')]");
    public final By BUTTON_CONTINUE = By.xpath("//input[contains(@class,'submit-button btn btn_primary cart_button btn_action')]");
    public final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");
    public final By FIRST = By.id("first-name");
    public final By LAST = By.id("last-name");
    public final By ZIP = By.id("postal-code");

    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void openCheckOutStepOne() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void clickButtonCart() {
        driver.findElement(BUTTON_CART).click();
    }

    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }
    public void clickButtonContinue() {
        driver.findElement(BUTTON_CONTINUE).click();
    }
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public void inputFirst(String FirstName) {
        driver.findElement(FIRST).sendKeys(FirstName);
    }
    public void inputLast(String LastName) {
        driver.findElement(LAST).sendKeys(LastName);
    }
    public void inputZip(String ZipCode) {
        driver.findElement(ZIP).sendKeys(ZipCode);
    }
}