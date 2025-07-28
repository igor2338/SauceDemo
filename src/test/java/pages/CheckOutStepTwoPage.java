package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CheckOutStepTwoPage extends BasePage {

    public final By TITLE = By.xpath("//span[text()='Checkout: Overview']");
    public final By BUTTON_CANCEL = By.id("cancel");

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Корзина")
    @Override
    public CheckOutStepTwoPage open() {
        driver.get(BASE_URL + "checkout-step-two.html");
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public CheckOutStepTwoPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return this;
    }

    @Override
    public BasePage isElement() {
        return null;
    }

    @Step("Нажатие кнопки Cancel")
    public void clickButtonCancel() {
        log.info ("Tap button Cancel");
        driver.findElement(BUTTON_CANCEL).click();
    }

    @Step("Поиск количество элементов на странице")
    public CheckOutStepTwoPage isElements(String count) {
        assertEquals(driver.findElement(TITLE).getSize(),
                count,
                "Количество не соответствует");
        return this;
    }

    @Override
    public BasePage removeProduct() {
        return null;
    }
}
