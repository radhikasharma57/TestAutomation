package stepDefinitions;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TextContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;

public class CheckoutPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
TextContextSetup textContextSetup;
public CheckoutPage checkoutPage;
public String offerPageProductName;
public CheckoutPageStepDefinition(TextContextSetup textContextSetup)
{
	this.textContextSetup=textContextSetup;
	this.checkoutPage=textContextSetup.pageObjectManager.getCheckoutPage();
}


@Then("verify user has ability to enter promo code and place the order")
public void verify_user_has_ability_to_enter_promo()
{
	
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
}

@Then("^User proceeds to Checkout and Validate the (.+) of items in checkout page$")
public void user_proceeds_to_checkout(String name) throws InterruptedException
{
	checkoutPage.CheckoutItems();
	//Thread.sleep(2000);
}


}
