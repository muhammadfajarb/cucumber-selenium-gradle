package com.fajarb.stepdef;

import com.fajarb.BaseTest;
import com.fajarb.page.CartPage;
import com.fajarb.page.DetailProductPage;
import com.fajarb.page.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CartStepDef extends BaseTest {

    HomePage homePage;
    CartPage cartPage;
    DetailProductPage detailProductPage;

    @When("user click add to cart button with following id:")
    public void userClickAddToCartButtonWithFollowingId(List<String> items) {
        homePage = new HomePage(driver);
        homePage.clickAddToCartButton(items);
    }

    @And("user go to cart page")
    public void userGoToCartPage() {
        homePage = new HomePage(driver);
        homePage.goToCartPage();
    }

    @Then("cart should contain {string}")
    public void cartShouldContain(String item) throws InterruptedException {
        Thread.sleep(5000);
    }


    @Then("cart should contain the following items name:")
    public void cartShouldContainTheFollowingItemsName(List<String> items) throws InterruptedException {
        cartPage = new CartPage(driver);
        cartPage.checkIfContainItems(items);

    }

    @And("user is on detail product page {string}")
    public void userIsOnDetailProductPage(String productName) {
        detailProductPage = new DetailProductPage(driver);
        detailProductPage.validateOnDetailProductPage(productName);
    }

    @When("user click add to cart button with id {string}")
    public void userClickAddToCartButtonWithId(String idButton) {
        detailProductPage = new DetailProductPage(driver);
        detailProductPage.clickAddToCartButton(idButton);
    }

    @Then("cart should contain product {string}")
    public void cartShouldContainProduct(String item) {
        cartPage = new CartPage(driver);
        cartPage.checkIfContainItem(item);
    }

    @And("user click on product with the name {string}")
    public void userClickOnProductWithTheName(String item) {
        homePage = new HomePage(driver);
        homePage.clickProductName(item);
    }
}
