package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "LoginDataForCheckout")
    public Object[][] loginDataForCheckout() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(priority = 1, dataProvider = "LoginDataForCheckout", description = "Проверка кнопки корзина",
            testName = "Позитивный. Проверка кнопки корзина",
            groups = {"Checkout"})
    public void checkButtonCart(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
        checkOutStepOnePage.clickButtonCart();
        assertTrue(cartPage.isPageOpened());
    }

    @Test(priority = 2, dataProvider = "LoginDataForCheckout", description = "Проверка кнопки Cancel",
            testName = "Позитивный. Проверка кнопки Cancel",
            groups = {"Checkout"})
    public void checkButtonCancel(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
        checkOutStepOnePage.clickButtonCancel();
        assertTrue(cartPage.isPageOpened());
    }

    @Test(priority = 3, dataProvider = "LoginDataForCheckout", description = "Проверка формы покупки",
            testName = "Негативный. Проверка формы покупки",
            groups = {"Checkout"})
    public void checkFormNegative(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: First Name is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputFirst("fn");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: Last Name is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputLast("ln");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: First Name is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputZip("zip");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: First Name is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputFirst("fn");
        checkOutStepOnePage.inputLast("ln");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: Postal Code is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputLast("ln");
        checkOutStepOnePage.inputZip("zip");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: First Name is required",
                "Ошибка не соответствует");
        driver.navigate().refresh();
        checkOutStepOnePage.inputFirst("fn");
        checkOutStepOnePage.inputZip("zip");
        checkOutStepOnePage.clickButtonContinue();
        assertEquals(checkOutStepOnePage.getErrorMessage(),
                "Error: Last Name is required",
                "Ошибка не соответствует");
    }

    @Test(priority = 4, dataProvider = "LoginDataForCheckout", description = "Позитивный. Проверка формы покупки",
            testName = "Позитивный. Проверка формы покупки",
            groups = {"Checkout"})
    public void checkFormPositive(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
        checkOutStepOnePage.inputFirst("fn");
        checkOutStepOnePage.inputLast("ln");
        checkOutStepOnePage.inputZip("zip");
        checkOutStepOnePage.clickButtonContinue();
        assertTrue(checkOutStepTwoPage.isPageOpened());
    }

    @Test(priority = 5, dataProvider = "LoginDataForCheckout", description = "Проверка формы покупки шаг 2",
            testName = "Негативный. Проверка формы покупки шаг 2",
            groups = {"Checkout"})
    public void checkFormStepTwoNegative(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
        checkOutStepOnePage.inputFirst("fn");
        checkOutStepOnePage.inputLast("ln");
        checkOutStepOnePage.inputZip("zip");
        checkOutStepOnePage.clickButtonContinue();
        assertTrue(checkOutStepTwoPage.isPageOpened());
        checkOutStepTwoPage.clickButtonCancel();
        assertEquals(checkOutStepTwoPage.isElement(),
                0,
                "Ошибка отображения страницы");
    }
}