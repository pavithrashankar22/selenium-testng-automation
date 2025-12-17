package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // Page locators
    private By productsTitle = By.className("title");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public void addItemToCart(String productId) {
        By addToCartButton = By.id("add-to-cart-" + productId);
        driver.findElement(addToCartButton).click();
    }

    public void removeItemFromCart(String productId) {
        By removeButton = By.id("remove-" + productId);
        driver.findElement(removeButton).click();
    }

    public boolean isCartBadgeDisplayed() {
        return driver.findElements(cartBadge).size() > 0;
    }

    public int getCartItemCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
