package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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

    @Step("Открытие страницы Корзина")
    @Override
    public CheckOutStepOnePage open() {
        log.info("Open page checkout-step-one");
        driver.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public CheckOutStepOnePage isPageOpened() {
        log.info("Display element oт page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Step("Нажатие кнопки Корзина")
    public void clickButtonCart() {
        log.info("Tap button Cart");
        driver.findElement(BUTTON_CART).click();
    }

    @Step("Нажатие кнопки Cancel")
    public void clickButtonCancel() {
        log.info("Tap button Cancel");
        driver.findElement(BUTTON_CANCEL).click();
    }

    @Step("Нажатие кнопки Continue")
    public void clickButtonContinue() {
        log.info("Tap button Continue");
        driver.findElement(BUTTON_CONTINUE).click();
    }

    @Step("Получение текста ошибки")
    public String getErrorMessage() {
        log.info("Get error");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Ввод имени в форму покупки")
    public void inputFirst(String firstName) {
        log.info("Enter firstname in form: {}", firstName);
        driver.findElement(FIRST).sendKeys(firstName);
    }

    @Step("Ввод фамилии в форму покупки")
    public void inputLast(String lastName) {
        log.info("Enter lastname in form: {}", lastName);
        driver.findElement(LAST).sendKeys(lastName);
    }

    @Step("Ввод zip кода в форму покупки")
    public void inputZip(String zipCode) {
        log.info("Enter ZIP in form: {}", zipCode);
        driver.findElement(ZIP).sendKeys(zipCode);
    }
}