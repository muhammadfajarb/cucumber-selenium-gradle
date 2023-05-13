package com.fajarb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    WebDriver driver;
    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By addToCartButton(String item) {
        return By.xpath("//button[@id=\"" + item + "\"]");
    }
    By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By productName(String item) {
        return By.xpath("//div[@class=\"inventory_item_name\" and text()=\"" + item + "\"]");
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnHomePage() {
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void clickAddToCartButton(List<String> items) {
        for (String item : items) {
            driver.findElement(addToCartButton(item)).click();
        }
    }

    public void goToCartPage() {
        driver.findElement(cartButton).click();
    }

    public void clickProductName(String item) {
        driver.findElement(productName(item)).click();
    }
}
