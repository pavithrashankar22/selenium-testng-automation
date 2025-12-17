package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventorySmokeTest extends BaseTest {

    @Test
    public void userCanAddAndRemoveBikeLightFromCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        // Verify inventory page
        Assert.assertTrue(
                inventoryPage.isProductsDisplayed(),
                "Inventory page did not load"
        );

        // Add bike light
        inventoryPage.addItemToCart("sauce-labs-bike-light");

        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                1,
                "Cart count should be 1 after adding bike light"
        );

        // Remove bike light
        inventoryPage.removeItemFromCart("sauce-labs-bike-light");

        Assert.assertFalse(
                inventoryPage.isCartBadgeDisplayed(),
                "Cart badge still displayed after removing item"
        );
    }
}
