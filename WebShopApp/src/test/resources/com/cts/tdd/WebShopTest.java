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

import com.cts.pages.Checkoutspage;
import com.cts.baseclass.BaseClass;
import com.cts.pages.Basepage;
import com.cts.pages.Loginpage;
import com.cts.pages.SelectProductpage;
import com.cts.pages.Shoppingcartpage;
import com.cts.tdd.WebShopTest;
import com.cts.utility.ExcelReader;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebShopTest extends BaseClass {
	WebDriver driver;
	
	  Loginpage loginpage; 
	  Basepage basepage; 
	  SelectProductpage selectproductpage;
	  Shoppingcartpage shoppingcartpage; 
	  Checkoutspage addresspage; 
	  WebShopTest webshoptest;
	  ExcelReader excelreader;
		final static Logger logger = LogManager.getLogger(WebShopTest.class.getName());

	
	@BeforeSuite
	public  void initDriver( String browser)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe\");
		driver = new ChromeDriver();
		driver=InitDriver("chrome");
		driver.manage().window().maximize();
	}
	@Parameters({"Browsers"})
	@BeforeTest
	public void launchBrowser()
	{
		driver.get("http://demowebshop.tricentis.com/");
		logger.debug("Opening the browser with WebShopApp");
		  loginpage = new Loginpage(driver);
		  basepage=new Basepage(driver);
		  selectproductpage=new SelectProductpage(driver); 
		  shoppingcartpage=new Shoppingcartpage(driver); 
		  addresspage=new Checkoutspage(driver);
		  webshoptest=new WebShopTest();
		  excelreader=new ExcelReader();
		 
	}
	@DataProvider(name = "user_details")
	public Object[][] getData() throws IOException  {
		
		//Object[][] testData = null;
	
			return excelreader.getData();
}

	@Test(priority = 0,dataProvider = "user_details")
	public void validatelogin(String email,String password) {
		loginpage.Loginlink();
		logger.trace("Processing Valid login with username and password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.setUsername(email);
		loginpage.setPassword(password);
		loginpage.Btnclick();
	}
	@Test(priority = 1)
	public void Productselect() {
		logger.trace("processing select product");

		selectproductpage.AddBook();
		selectproductpage.AddComputer();
		selectproductpage.AddPhone();
	}
	@Test(priority = 2)
	public void Shoppingcart() {
		logger.trace("processing shopping cart");

		selectproductpage.Shoppingcartlink();
		shoppingcartpage.Selectcountry();
		shoppingcartpage.Selectstate();
		shoppingcartpage.Zipcode();
		shoppingcartpage.Acceptation();
	}
	
	  @Test(priority = 3) 
	  public void CheckoutAddress() {
			logger.trace("processing check out");

	  shoppingcartpage.Checkoutlink(); 
	  addresspage.Selectcontinue(); 
	  }
	
@Test
public void Logout() {
	logger.warn("Logging out of the WebPage");

basepage.Logout();
}
@AfterTest
public void CloseBrowser() {
	logger.error("Driver is going to get closed");

	driver.close();
}
}