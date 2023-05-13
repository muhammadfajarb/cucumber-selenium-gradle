package com.fajarb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetailProductPage {
    WebDriver driver;
    By productTitle = By.xpath("//*[@class=\"inventory_details_name large_size\"]");

    private By addToCartButton(String idButton) {
        return By.xpath("//*[@id=\"" + idButton + "\"]");
    }

    public DetailProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOnDetailProductPage(String productName) {
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals(productName, productElement.getText());
    }

    public void clickAddToCartButton(String idButton) {
        driver.findElement(addToCartButton(idButton)).click();
    }
}
