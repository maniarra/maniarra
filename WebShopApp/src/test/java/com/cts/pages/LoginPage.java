package com.cts.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	WebElement userEmailElement;
	@FindBy(id = "Password")
	WebElement userPasswordElement;
	@FindBy(css = ".login-button")
	WebElement loginbtnElement;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
//clicks to enter username
	public void setUsername(String email) {
		userEmailElement.sendKeys(email);
	}
//clicks to enter password
	public void setPassword(String password) {
		userPasswordElement.sendKeys(password);
	}
//clicks on login button and logs in after entering valid details
	public void Btnclick() {
		loginbtnElement.click();
	}

}
