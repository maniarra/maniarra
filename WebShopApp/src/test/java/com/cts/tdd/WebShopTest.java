package com.cts.tdd;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cts.pages.CheckoutsPage;
import com.cts.baseclass.BaseClass;
import com.cts.pages.BasePage;
import com.cts.pages.LoginPage;
import com.cts.pages.SelectproductPage;
import com.cts.pages.ShippingcartPage;
import com.cts.tdd.WebShopTest;
import com.cts.utility.ExcelReport;
import com.cts.utility.ScreenShot;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebShopTest extends BaseClass {
	WebDriver driver;

	LoginPage loginpage;
	BasePage basepage;
	SelectproductPage selectproductpage;
	ShippingcartPage shoppingcartpage;
	CheckoutsPage addresspage;
	WebShopTest webshoptest;
	ExcelReport excelreader;
	ScreenShot screenshot;
	final static Logger logger = LogManager.getLogger(WebShopTest.class.getName());

	@BeforeSuite
	//user initializes driver
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters({ "Browsers" })
	@BeforeTest
	//user launches chrome
	public void launchBrowser() {
		driver.get("http://demowebshop.tricentis.com/");
		logger.info("Opening the browser with WebShopApp");
		loginpage = new LoginPage(driver);
		basepage = new BasePage(driver);
		selectproductpage = new SelectproductPage(driver);
		shoppingcartpage = new ShippingcartPage(driver);
		addresspage = new CheckoutsPage(driver);
		webshoptest = new WebShopTest();
		excelreader = new ExcelReport();
		screenshot = new ScreenShot(driver);

	}

	@DataProvider(name = "user_details")
	public Object[][] getData() throws IOException {

		// Object[][] testData = null;

		return excelreader.getData();
	}
	//user enters username and password and logs in
	@Test(priority = 0, dataProvider = "user_details")
	public void validatelogin(String email, String password) {
		loginpage.Loginlink();
		logger.info("Processing Valid login with username and password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.setUsername(email);
		loginpage.setPassword(password);
		loginpage.Btnclick();
	}
	//user selects the products
	@Test(priority = 1)
	public void Productselect() {
		logger.info("processing select product");

		selectproductpage.AddBook();
		selectproductpage.AddComputer();
		selectproductpage.AddPhone();
		screenshot.takeSnapShot("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\Screenshot.png");
	}
	//user opens shipping cart
	@Test(priority = 2)
	public void Shoppingcart() {
		logger.trace("processing shopping cart");

		selectproductpage.Shoppingcartlink();
		screenshot.takeSnapShot("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\Shoppingcart.png");
		shoppingcartpage.Selectcountry();
		shoppingcartpage.Selectstate();
		shoppingcartpage.Zipcode();
		shoppingcartpage.Acceptation();
	}
	//user opens checkout link
	@Test(priority = 3)
	public void CheckoutAddress() {
		logger.info("processing check out");

		shoppingcartpage.Checkoutlink();
		screenshot.takeSnapShot("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\checkout.png");
		addresspage.Selectcontinue();
	}
	//user logs out of the application
	@Test
	public void Logout() {
		logger.info("Logging out of the WebPage");

		basepage.Logout();
	}
	//user closes the browser
	@AfterTest
	public void CloseBrowser() {
		screenshot.takeSnapShot("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\closebrowser.png");
		logger.error("Driver is going to get closed");

		driver.close();
	}
}