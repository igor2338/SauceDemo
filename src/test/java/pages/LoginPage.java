package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    private final By LOGIN_FILED = By.id("user-name");
    private final By PASSWORD_FILED = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Корзина")
    @Override
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FILED));
        return this;
    }

    @Override
    public BasePage isElement() {
        return null;
    }

    @Override
    public BasePage removeProduct() {
        return null;
    }

    @Step("Авторизация")
    public LoginPage login(String user, String password) {
        driver.findElement(LOGIN_FILED).sendKeys(user);
        driver.findElement(PASSWORD_FILED).sendKeys(password);//name
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Получение сообщения")
    public LoginPage getErrorMessage(String message) {
        assertEquals(driver.findElement(ERROR_MESSAGE).getText(),
                message,
                "Сообщение не соответствует");
        return this;
    }
}