package com.fajarb.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage {
    WebDriver driver;
    By inputFirstName = By.xpath("//*[@id=\"first-name\"]");
    By inputLastName = By.xpath("//*[@id=\"last-name\"]");
    By inputPostalCode = By.xpath("//*[@id=\"postal-code\"]");
    By continueButton = By.xpath("//*[@id=\"continue\"]");
    By checkoutOverviewTitle = By.xpath("//*[@class=\"title\"]");
    By itemPrice = By.xpath("//*[@class=\"inventory_item_price\"]");
    By subTotalPrice = By.xpath("//*[@class=\"summary_subtotal_label\"]");
    By taxPrice = By.xpath("//*[@class=\"summary_tax_label\"]");
    By totalPriceWithTax = By.xpath("//*[contains(@class, \"summary_total_label\")]");
    By finishButton = By.xpath("//*[@id=\"finish\"]");
    By checkoutCompleteTitle = By.xpath("//*[@class=\"title\"]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillShippingInformation() {
        driver.findElement(inputFirstName).sendKeys("Muhammad");
        driver.findElement(inputLastName).sendKeys("Fajar B");
        driver.findElement(inputPostalCode).sendKeys("90123");
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void validateOnOverviewPage() {
        WebElement overviewTitle = driver.findElement(checkoutOverviewTitle);
        assertTrue(overviewTitle.isDisplayed());
        assertEquals("Checkout: Overview", overviewTitle.getText());
    }

    public void validateTotalPrice() {
        List<WebElement> price = driver.findElements(itemPrice);
        String priceText;
        float totalPrice = 0, subTotal, tax, priceWithTax;

        for (WebElement itemPrice : price) {
            priceText = itemPrice.getText().replace("$", "");
            totalPrice += Float.parseFloat(priceText);
        }

        WebElement subTotalText = driver.findElement(subTotalPrice);
        subTotal = Float.parseFloat(subTotalText.getText().replace("Item total: $", ""));

        assertEquals(totalPrice, subTotal);

        WebElement taxPriceText = driver.findElement(taxPrice);
        tax = Float.parseFloat(taxPriceText.getText().replace("Tax: $", ""));

        WebElement priceWithTaxText = driver.findElement(totalPriceWithTax);
        priceWithTax = Float.parseFloat(priceWithTaxText.getText().replace("Total: $", ""));

        assertEquals(totalPrice + tax, priceWithTax);
        System.out.println(totalPrice + tax + " " + priceWithTax);

    }

    public void clickFinishButton() {
        WebElement finishBtn = driver.findElement(finishButton);
        finishBtn.click();
    }

    public void validateOnCheckoutComplete() {
        WebElement checkoutComplete = driver.findElement(checkoutCompleteTitle);
        assertTrue(checkoutComplete.isDisplayed());
        assertEquals("Checkout: Complete!", checkoutComplete.getText());
    }
}
