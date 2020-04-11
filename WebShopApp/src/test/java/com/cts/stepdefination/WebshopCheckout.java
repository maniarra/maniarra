package com.cts.stepdefination;

import org.openqa.selenium.WebDriver;

import com.cts.baseclass.BaseClass;
import com.cts.pages.CheckoutsPage;
import com.cts.pages.LoginPage;
import com.cts.pages.SelectproductPage;
import com.cts.pages.ShippingcartPage;
import com.cts.utility.ExcelReport;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebshopCheckout extends BaseClass {
	WebDriver driver;
	CheckoutsPage checkout;
	ExcelReport excelreader = new ExcelReport();

	@Given("^the user launch the chrome application i am on the home page and selects the products and selects shipping cart link logs with (.+) and (.+)$")
	public void the_user_launch_the_chrome_application_i_am_on_the_home_page_and_selects_the_products_and_selects_shipping_cart_link_logs_with_and(String email,String password)
			throws Throwable {
		driver = InitDriver("chrome");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Loginlink();
		loginpage.setUsername(email);
		loginpage.setPassword(password);
		loginpage.Btnclick();
		
		SelectproductPage selectproductpage = new SelectproductPage(driver);
		selectproductpage.AddBook();
		selectproductpage.AddComputer();
		selectproductpage.AddPhone();
		
		ShippingcartPage shoppingcartpage = new ShippingcartPage(driver);
		shoppingcartpage.Shoppingcartlink();
		shoppingcartpage.Selectcountry();
		shoppingcartpage.Selectstate();
		shoppingcartpage.Zipcode();
		shoppingcartpage.Acceptation();

	}
	
	@Then("^user cicks on checkout link$")
	public void user_cicks_on_checkout_link() throws Throwable {
		checkout = new CheckoutsPage(driver);
		checkout.Checkoutlink();
	}

	@Then("^the user clicks on continue buttons as address is already filled$")
	public void the_user_clicks_on_continue_buttons_as_address_is_already_filled() throws Throwable {
		checkout.Selectcontinue();
	}

	@Then("^click on logout$")
	public void click_on_logout() throws Throwable {
		checkout.Logout();
	}
	 @Then("^closes the browser$")
	    public void closes_the_browser() throws Throwable {
	        driver.close();
	    }

}
