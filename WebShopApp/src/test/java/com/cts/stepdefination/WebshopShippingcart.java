package com.cts.stepdefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cts.baseclass.BaseClass;
import com.cts.pages.LoginPage;
import com.cts.pages.SelectproductPage;
import com.cts.pages.ShippingcartPage;
import com.cts.utility.ExcelReport;
import com.cts.utility.ScreenShot;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebshopShippingcart extends BaseClass {
	final static Logger logger = LogManager.getLogger(WebshopLogin.class.getName());

	WebDriver driver=null;
	ShippingcartPage shoppingcartpage;
	ExcelReport excelreadrer = new ExcelReport();
	ScreenShot screenshot = new ScreenShot(driver);

	@Given("^the user launch the chrome application i am on the home page and selects and logs in with (.+) and (.+)$")
	public void the_user_launch_the_chrome_application_i_am_on_the_home_page_and_selects_and_logs_in_with_and(String email,String password)
			throws Throwable {
		driver = InitDriver("chrome");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Loginlink();
		loginpage.setUsername(email);
		loginpage.setPassword(password);
		loginpage.Btnclick();
		logger.info("user logs in");
		SelectproductPage selectproductpage = new SelectproductPage(driver);
		selectproductpage.AddBook();
		selectproductpage.AddComputer();
		selectproductpage.AddPhone();
		logger.info("completes selecting products");
	}

	@Given("^the user clicks the shopping cart link$")
	public void the_user_clicks_the_shopping_cart_link() throws Throwable {
		shoppingcartpage = new ShippingcartPage(driver);
		shoppingcartpage.Shoppingcartlink();
		logger.info("clicks on shipping cart link");
	}

	@Then("^the user selects the country$")
	public void the_user_selects_the_country() throws Throwable {
		shoppingcartpage.Selectcountry();
	}

	@And("^the user selects state$")
	public void the_user_selects_state() throws Throwable {
		shoppingcartpage.Selectstate();
	}

	@And("^the user enters zipcode$")
	public void the_user_enters_zipcode() throws Throwable {
		shoppingcartpage.Zipcode();
	}

	@And("^the user clicks on accept$")
	public void the_user_clics_on_accept() throws Throwable {
		shoppingcartpage.Acceptation();
	}

}
