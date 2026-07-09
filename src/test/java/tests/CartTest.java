package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.*;

public class CartTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(description = "Add one product to cart")

    public void addOneProductToCart() {
        inventoryPage.addBackpackToCart();
        assertEquals("1", inventoryPage.getCartBadge());
    }

    @Test(description = "Add two product to cart")
    public void addTwoProductsToCart() {
        inventoryPage.addBackpackToCart();
        inventoryPage.addtShirtToCart();
        assertEquals("2", inventoryPage.getCartBadge());
    }
    @Test(description = "Verify product in cart")
    public void verifyProductInCart() {
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        assertTrue(cartPage.isBackpackDisplayed());
    }

    @Test(description = "Remove product from cart")
    public void removeProductFromCart() {
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.removeBackpack();
        assertFalse(cartPage.isBackpackPresent());
    }

    @Test(description = "Remove one product from cart")
    public void removeOneProductFromTwoTest() {
        inventoryPage.addBackpackToCart();
        inventoryPage.addtShirtToCart();
        inventoryPage.openCart();
        cartPage.removeBackpack();
        assertFalse(cartPage.isBackpackPresent());
        assertTrue(cartPage.istShirtDisplayed());
    }
    @Test(description = "Cart should be saved after refresh page")
    public void cartShouldBeSavedAfterRefresh() {
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        driver.navigate().refresh();
        assertTrue(cartPage.isBackpackPresent());
    }
    @Test(description = "Cart should be saved after navigation")
    public void cartShouldBeSavedAfterNavigation() {
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.continueShopping();
        inventoryPage.openCart();
        assertTrue(cartPage.isBackpackDisplayed());
    }
}