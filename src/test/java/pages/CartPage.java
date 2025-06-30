package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public final By TITLE = By.xpath("//span[text()='Your Cart']");
    public final By COUNT = By.cssSelector(".shopping_cart_badge");
    public final By REMOVE = By.xpath("//button[contains(@class,'btn btn_secondary btn_small cart_button')]");
    public final By BUTTON = By.id("continue-shopping");
    public final By BUTTON_CHECKOUT = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public int isElement() {
        return driver.findElements(COUNT).size();
    }

    public void removeProduct() {
        driver.findElement(REMOVE).click();
    }

    public void buttonContinueShopping() {
        driver.findElement(BUTTON).click();
    }

    public void buttonCheckOut() {
        driver.findElement(BUTTON_CHECKOUT).click();
    }
}