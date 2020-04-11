package com.cts.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	WebDriver driver;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}
	//method code to take screen shot
	public void takeSnapShot(String path1) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(Source, new File(path1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
