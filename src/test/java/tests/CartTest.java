package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    @Severity(SeverityLevel.NORMAL)
    @Owner("Бессолицын Игорь Валерьевич")
    @Link("https://www.saucedemo.com/cart.html")
    @Epic("Cart")
    @Feature("ProductsInCart")
    @Story("EmptyCart")
    @TmsLink("ITM-4")
    @Issue("ITM-4-2")
    @Description("Проверка отсутствия товара в корзине")
    public void checkEmptyCart(String user, String password) {
        loginPage.open()
                .login(user, password);
        cartPage.open()
                .isPageOpened()
                .isElement("1");
    }

    @Test(priority = 2, dataProvider = "LoginDataForCart", description = "Проверка добавления/наличия товара в корзине",
            groups = {"Cart"})
    public void checkAddProductCart(String user, String password) {
        loginPage.open()
                .login(user, password);
        productsPage.open()
                .isPageOpened();
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open()
                .isPageOpened()
                .isElement("2");
    }

    @Test(priority = 3, dataProvider = "LoginDataForCart", description = "Проверка добавления/удаления/отсутствия товара в корзине",
            groups = {"Cart"})
    public void removeProductCart(String user, String password) {
        loginPage.open()
                .login(user, password);
        productsPage.open()
                .isPageOpened();
        productsPage.addProduct();
        productsPage.addProduct();
        cartPage.open()
                .isPageOpened()
                .removeProduct()
                .removeProduct()
                .isElement("0");
    }

    @Test(priority = 4, dataProvider = "LoginDataForCart", description = "Проверка кнопки Continue в корзине",
            groups = {"Cart"})
    public void checkButtonContinueShopping(String user, String password) {
        loginPage.open()
                .login(user, password);
        cartPage.open()
                .isPageOpened();
        cartPage.buttonContinueShopping();
        productsPage.isPageOpened();
    }

    @Test(priority = 5, dataProvider = "LoginDataForCart", description = "Проверка кнопки Checkout в корзине",
            groups = {"Cart"})
    public void checkButtonCheckOut(String user, String password) {
        loginPage.open()
                .login(user, password);
        cartPage.open()
                .isPageOpened();
        cartPage.buttonCheckOut();
        checkOutStepOnePage.isPageOpened();
    }
}