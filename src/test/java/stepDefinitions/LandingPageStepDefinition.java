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
import pageObjects.LandingPage;

public class LandingPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
TextContextSetup textContextSetup;
LandingPage landingPage;
public LandingPageStepDefinition(TextContextSetup textContextSetup)
{
	this.textContextSetup=textContextSetup;
	 this.landingPage=textContextSetup.pageObjectManager.getLandingPage(); 
}
public String offerPageProductName;

@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));	
}


@When("^user searched with Shortname (.+) and extracted actual name of product$")
public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
	
	landingPage.searchItem(shortname);
	//textContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	Thread.sleep(2000);
	textContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	
	System.out.println("Product name:"+textContextSetup.landingPageProductName);
}

@When("Added {string} items of the selected product to the cart")
      public void Added_items_product(String quantity)
      {
	landingPage.incrementQuantity(Integer.parseInt(quantity));
	landingPage.addToCart();
      }
}



