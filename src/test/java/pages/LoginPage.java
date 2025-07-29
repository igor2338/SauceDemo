package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

@Log4j2
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
        log.info("Open Login page");
        driver.get(BASE_URL);
        return this;
    }

    @Step("Отображение элемента на странице Корзина")
    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FILED));
            log.info("Login page is opened");
        } catch (TimeoutException e){
            log.error(e.getMessage());
            Assert.fail("Page isn't open");
        }
        return this;
    }

    @Step("Авторизация")
    public LoginPage login(String user, String password) {
        log.info("Log in with credential: {}, {}", user, password);
        driver.findElement(LOGIN_FILED).sendKeys(user);
        driver.findElement(PASSWORD_FILED).sendKeys(password);//name
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Получение сообщения")
    public LoginPage getErrorMessage(String message) {
        log.info("Get mistake");
        assertEquals(driver.findElement(ERROR_MESSAGE).getText(),
                message,
                "Сообщение не соответствует");
        return this;
    }
}