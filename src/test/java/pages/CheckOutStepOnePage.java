package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage {

    public final By TITLE = By.xpath("//span[text()='Checkout: Your Information']");

    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void openCheckOutStepOne() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }
}