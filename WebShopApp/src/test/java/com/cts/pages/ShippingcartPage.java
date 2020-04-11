package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingcartPage extends BasePage {

	@FindBy(id = "CountryId")
	WebElement countryidclick;
	@FindBy(id = "CountryId")
	WebElement selectcountryid;
	@FindBy(id = "StateProvinceId")
	WebElement selectstate;
	@FindBy(id = "ZipPostalCode")
	WebElement clickzipcode;
	@FindBy(id = "ZipPostalCode")
	WebElement enterzipcode;
	@FindBy(name = "estimateshipping")
	WebElement clickestimateshipping;
	@FindBy(id = "termsofservice")
	WebElement clicktermsofservice;

	public ShippingcartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
//user selects country
	public void Selectcountry() {
		countryidclick.click();
		selectcountryid.click();
	}
//user selects state
	public void Selectstate() {
		selectstate.click();
	}
//user enters zipcode
	public void Zipcode() {
		clickzipcode.click();
		enterzipcode.sendKeys("600119");
	}
//user accepts terms and conditions
	public void Acceptation() {
		clickestimateshipping.click();
		clicktermsofservice.click();
	}
}
