package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	@FindBy(linkText = "Log in")
	WebElement loginlink;
	@FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
	WebElement ShoppingcartLink;
	@FindBy(id = "checkout")
	WebElement Checkoutlink;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement logoutlink;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//clicks login link		
	public void Loginlink() {
		loginlink.click();

	}
//clicks shoppingcart link
	public void Shoppingcartlink() {
		ShoppingcartLink.click();
	}
//clicks checkout link
	public void Checkoutlink() {
		Checkoutlink.click();

	}
//clicks logout link
	public void Logout() {
		logoutlink.click();
	}
}
