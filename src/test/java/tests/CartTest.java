package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @DataProvider(name = "LoginDataForCart")
    public Object[][] loginDataForCart() {
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(priority = 1, dataProvider = "LoginDataForCart", description = "Проверка отсутствия товара в корзине",
            testName = "Позитивный. Проверка отсутствия товара в корзине",
            groups = {"Cart"})
    public void checkEmptyCart(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        assertEquals(cartPage.isElement(),
                0,
                "Ошибка наличия товара в корзине");
    }

    @Test(priority = 2, dataProvider = "LoginDataForCart", description = "Проверка добавления/наличия товара в корзине",
            groups = {"Cart"})
    public void checkAddProductCart(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        assertEquals(cartPage.isElement(),
                1,
                "Ошибка добавления/наличия товара в корзине");
    }

    @Test(priority = 3, dataProvider = "LoginDataForCart", description = "Проверка добавления/удаления/отсутствия товара в корзине",
            groups = {"Cart"})
    public void removeProductCart(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.removeProduct();
        cartPage.removeProduct();
        assertEquals(cartPage.isElement(),
                0,
                "Ошибка наличия товара в корзине");
    }

    @Test(priority = 4, dataProvider = "LoginDataForCart", description = "Проверка кнопки Continue в корзине",
            groups = {"Cart"})
    public void checkButtonContinueShopping(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonContinueShopping();
        assertTrue(productsPage.isPageOpened());
    }

    @Test(priority = 5, dataProvider = "LoginDataForCart", description = "Проверка кнопки Checkout в корзине",
            groups = {"Cart"})
    public void checkButtonCheckOut(String user, String password) {
        loginPage.open();
        loginPage.login(user, password);
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
    }
}