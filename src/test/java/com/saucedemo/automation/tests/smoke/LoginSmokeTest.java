package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSmokeTest extends BaseTest {

    @Test
    public void validUserShouldLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(
                inventoryPage.isProductsDisplayed(),
                "Login failed: Inventory page was not displayed"
        );
    }
}
