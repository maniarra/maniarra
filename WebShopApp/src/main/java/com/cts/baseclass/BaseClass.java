package com.cts.baseclass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	WebDriver driver;
	//Here we are initializing the driver 
	public WebDriver InitDriver(String browser)
	{
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		if(browser.equals("fireFox")) {
			System.setProperty("webdriver.firefx.driver", "\"E:\\geckodriver.exe\"");
			driver=new FirefoxDriver();
		}
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		return driver;
		
	}
	//quitting the driver
	public void quit() {

		driver.quit();
	}
	//method to save the screen shot after taking in a particular path
	public void getScreenshot(String result) throws IOException {
		System.out.println(driver);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\eclipse\\eclipse-jee-oxygen-R-win32-x86_64\\eclipse\\WebShopApp\\Screenshot" + result + "screenshot.png"));
	}
	
}
