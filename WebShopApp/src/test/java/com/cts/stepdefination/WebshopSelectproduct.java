package com.cts.stepdefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cts.baseclass.BaseClass;
import com.cts.pages.LoginPage;
import com.cts.pages.SelectproductPage;
import com.cts.utility.ExcelReport;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebshopSelectproduct extends BaseClass {
	final static Logger logger = LogManager.getLogger(WebshopLogin.class.getName());
	WebDriver driver;
	SelectproductPage selectproductpage;
	ExcelReport excelreader = new ExcelReport();

	@Given("^the user launch the chrome application i am on the home page and logs in with (.+) and (.+)$")
	public void the_user_launch_the_chrome_application_i_am_on_the_home_page_and_logs_in_with_and(String email,String password) throws Throwable {
		driver = InitDriver("chrome");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.Loginlink();
		loginpage.setUsername(email);
		loginpage.setPassword(password);
		loginpage.Btnclick();
		logger.info("user logs in");
	}

	@Given("^the user clicks on books$")
	public void the_user_clicks_on_books() throws Throwable {

		selectproductpage = new SelectproductPage(driver);
		System.out.println("The user Clicks on books");
		selectproductpage.AddBook();
	}

	@Then("^the user clicks on computers$")
	public void the_user_clicks_on_computers() throws Throwable {
		selectproductpage.AddComputer();
	}

	@Then("^the user clicks on phones$")
	public void the_user_clicks_on_phones() throws Throwable {
		selectproductpage.AddPhone();
		logger.info("completes selecting products");
	}
}
