package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public abstract class CartPage extends BasePage {
    public final By TITLE = By.xpath("//span[text()='Your Cart']");
    public final By COUNT = By.cssSelector(".shopping_cart_badge");
    public final By REMOVE = By.xpath("//button[contains(@class,'btn btn_secondary btn_small cart_button')]");
    public final By BUTTON = By.id("continue-shopping");
    public final By BUTTON_CHECKOUT = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Корзина")
    @Override
    public CartPage open() {
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public CartPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Поиск количество элементов на странице")
    public CartPage isElement(String count) {
        assertEquals(driver.findElement(COUNT).getText(),
                count,
                "Количество не соответствует");
        return this;
    }

    @Step("Удаление товара из корзины")
    @Override
    public CartPage removeProduct() {
        driver.findElement(REMOVE).click();
        return this;
    }

    public void buttonContinueShopping() {
        driver.findElement(BUTTON).click();
    }

    public void buttonCheckOut() {
        driver.findElement(BUTTON_CHECKOUT).click();
    }
}