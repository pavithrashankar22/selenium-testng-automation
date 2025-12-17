package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.CartPage;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartSmokeTest extends BaseTest {

    @Test
    public void userCanViewCorrectItemInCart() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Step 2: Inventory page
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(
                inventoryPage.isProductsDisplayed(),
                "Inventory page not loaded"
        );

        // Step 3: Add item to cart
        inventoryPage.addItemToCart("sauce-labs-backpack");
        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                1,
                "Cart count should be 1 after adding item"
        );

        // Step 4: Open cart
        inventoryPage.openCart();

        // Step 5: Cart validations
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isCartPageLoaded(),
                "Cart page not loaded"
        );

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack",
                "Incorrect item in cart"
        );

        Assert.assertEquals(
                cartPage.getCartItemQuantity(),
                1,
                "Item quantity should be 1"
        );
    }
}
