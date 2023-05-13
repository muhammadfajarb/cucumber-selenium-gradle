package com.fajarb.stepdef;

import com.fajarb.BaseTest;
import com.fajarb.page.CartPage;
import com.fajarb.page.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDef extends BaseTest {

    CartPage cartPage;
    CheckoutPage checkoutPage;


    @When("user click checkout")
    public void userClickCheckout() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();
    }

    @And("user fill shipping information")
    public void userFillShippingInformation() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillShippingInformation();
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @And("user on checkout overview page")
    public void userOnCheckoutOverviewPage() {
        checkoutPage.validateOnOverviewPage();
    }

    @And("click finish button")
    public void clickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("checkout complete")
    public void checkoutComplete() {
        checkoutPage.validateOnCheckoutComplete();
    }

    @And("total price is correct")
    public void totalPriceIsCorrect() {
        checkoutPage.validateTotalPrice();
    }
}
