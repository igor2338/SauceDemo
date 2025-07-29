package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class CartPage extends BasePage {
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
        log.info("Open Cart page");
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public CartPage isPageOpened() {
        log.info("Display element");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
            log.info("Cart page is opened");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Cart page isn't open");
        }
        return this;
    }

    @Step("Сравнение количества элементов на странице")
    public void isElement(String count) {
        log.info("Comparison of elements");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
            assertEquals(driver.findElement(COUNT).getText(),
                    count);
            log.info("Quantity is correct");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Quantity isn't correct");
        }
    }

    @Step("Проверка отсутствия товара в корзине")
    public void isElements() {
        log.info("Comparison of elements");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
            assertTrue(driver.findElements(COUNT).isEmpty());
            log.info("Quantity is correct");
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Quantity isn't correct");
        }
    }

    @Step("Удаление товара из корзины")
    public CartPage removeProduct() {
        log.info("Remove of element");
        driver.findElement(REMOVE).click();
        return this;
    }

    public void buttonContinueShopping() {
        log.info("Tap of button Continue");
        driver.findElement(BUTTON).click();
    }

    public void buttonCheckOut() {
        log.info("Tap of button Checkout");
        driver.findElement(BUTTON_CHECKOUT).click();
    }
}