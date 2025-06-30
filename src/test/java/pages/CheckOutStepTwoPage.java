package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage extends BasePage {

    public final By TITLE = By.xpath("//span[text()='Checkout: Overview']");
    public final By BUTTON_CANCEL = By.id("cancel");

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public void openCheckOutStepTwo() {
        driver.get(BASE_URL + "checkout-step-two.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void clickButtonCancel() {
        driver.findElement(BUTTON_CANCEL).click();
    }

    public int isElement() {
        return driver.findElements(TITLE).size();
    }
}
