package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkButtonCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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

    @Test
    public void checkButtonCancel() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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

    @Test
    public void checkFormNegative() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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

    @Test
    public void checkFormPositive() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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

    @Test
    public void checkFormStepTwoNegative() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
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