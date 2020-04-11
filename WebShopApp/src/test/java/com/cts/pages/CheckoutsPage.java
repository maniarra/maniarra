package com.cts.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutsPage extends BasePage {
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Clickcontinue1;
	@FindBy(xpath = "//input[@id='PickUpInStore']")
	WebElement selectcheckbox;
	@FindBy(css = ".new-address-next-step-button:nth-child(2)")
	WebElement Clickcontinue2;
	@FindBy(xpath = "//input[@id='paymentmethod_3']")
	WebElement selectpaymentmethod;;
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']/input")
	WebElement Clickcontinue3;;
	@FindBy(xpath = "//div[@id='payment-info-buttons-container']/input")
	WebElement Clickcontinue4;
	@FindBy(xpath = "//div[@id='confirm-order-buttons-container']/input")
	WebElement Clickcontinue5;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
	WebElement Clickcontinue6;

	public CheckoutsPage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
//user clicks on continue for payment and delivary option confirmation
	public void Selectcontinue() {
		Clickcontinue1.click();
		selectcheckbox.click();
		Clickcontinue2.click();
		selectpaymentmethod.click();
		Clickcontinue3.click();
		Clickcontinue4.click();
		Clickcontinue5.click();
		Clickcontinue6.click();
	}

}
