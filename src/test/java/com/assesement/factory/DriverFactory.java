package com.assesement.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	static WebDriver driver = null;

	public static void initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}
}
