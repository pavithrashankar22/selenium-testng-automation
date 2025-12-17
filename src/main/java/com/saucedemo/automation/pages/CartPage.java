package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Page locators
    private By cartTitle = By.className("title");               // "Your Cart"
    private By cartItemName = By.id("item_4_title_link");       // Sauce Labs Backpack
    private By cartItemQuantity = By.className("cart_quantity");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify cart page loaded
    public boolean isCartPageLoaded() {
        return driver.findElement(cartTitle).isDisplayed();
    }

    // Get item name in cart
    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    // Get quantity of item in cart
    public int getCartItemQuantity() {
        String quantityText = driver.findElement(cartItemQuantity).getText();
        return Integer.parseInt(quantityText);
    }
}
