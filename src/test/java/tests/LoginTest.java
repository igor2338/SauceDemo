package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(priority = 1, dataProvider = "LoginData",
            description = "Негативный. Авторизация без пароля. Проверка сообщения об ошибке",
            testName = "Негативный. Авторизация без пароля",
            groups = {"Login"})
    public void checkLoginWithoutPassword(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "Сообщение не соответствует");
    }

    @Test(priority = 2, dataProvider = "LoginData",
            description = "Негативный. Авторизация без логина. Проверка сообщения об ошибке",
            testName = "Негативный. Авторизация без логина",
            groups = {"Login"})
    public void checkLoginWithoutUsername(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "Сообщение не соответствует");
    }

    @Test(priority = 3, dataProvider = "LoginData",
            description = "Негативный. Авторизация с неверным логином, паролем. Проверка сообщения об ошибке",
            testName = "Негативный. Авторизация с неверным логином, паролем",
            groups = {"Login"})
    public void checkLoginWithNegativeValue(String user, String password, String message) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "Сообщение не соответствует");
    }

    @Test(priority = 4,
            description = "Позитивный. Авторизация с валидным логином, паролем. Проверка перехода на страницу Products",
            testName = "Позитивный. Авторизация с валидными данными",
            groups = {"Login"})
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }
}