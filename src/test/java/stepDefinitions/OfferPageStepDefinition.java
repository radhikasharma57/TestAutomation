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
import pageObjects.OffersPage;

public class OfferPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;

public String offerPageProductName;
TextContextSetup textContextSetup;
public OfferPageStepDefinition(TextContextSetup textContextSetup)
{
	this.textContextSetup=textContextSetup;
}

@Then("^user  serached for (.+) shortname in offers page$")
public void user_serached_for_shortname_in_offers_page(String shortname) throws InterruptedException {
	switchToOffersPage();
	OffersPage offersPage=textContextSetup.pageObjectManager.getOffersPage();
	
    //textContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	offersPage.searchItem(shortname);
    Thread.sleep(2000);
    offerPageProductName=offersPage.getProductName();
    System.out.println("Product name:"+offerPageProductName);
    
    
}

public void switchToOffersPage()
{
	LandingPage landingPage=textContextSetup.pageObjectManager.getLandingPage();
	landingPage.selectTopDeals();
	textContextSetup.genericUtils.SwitchWindowToChild();
	//textContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	
  
}

@Then("validate product name in offers page matches with Landing page")
public void validate_product_name_in_offers_page_matches_with_landing_page()  {
	
	Assert.assertEquals(offerPageProductName, textContextSetup.landingPageProductName);

	 System.out.println("Test Passed");
	
	
   
}
}



