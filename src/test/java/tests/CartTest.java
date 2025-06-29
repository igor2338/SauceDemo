package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void checkEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        assertEquals(cartPage.isElement(),
                0,
                "Ошибка наличия товара в корзине");
    }

    @Test
    public void checkAddProductCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        cartPage.addProduct();
        cartPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        assertEquals(cartPage.isElement(),
                1,
                "Ошибка добавления/наличия товара в корзине");
    }

    @Test
    public void removeProductCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.open();
        assertTrue(productsPage.isPageOpened());
        cartPage.addProduct();
        cartPage.addProduct();
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.removeProduct();
        cartPage.removeProduct();
        assertEquals(cartPage.isElement(),
                0,
                "Ошибка наличия товара в корзине");
    }

    @Test
    public void checkButtonContinueShopping() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonContinueShopping();
        assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void checkButtonCheckOut() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertTrue(cartPage.isPageOpened());
        cartPage.buttonCheckOut();
        assertTrue(checkOutStepOnePage.isPageOpened());
    }
}