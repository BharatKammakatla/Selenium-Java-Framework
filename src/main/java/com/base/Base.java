package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public void initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/bharatkammakatla/TestAutomation/SeleniumJavaFramework/src/main/resources/env.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName == "chrome") {
			System.setProperty("webdriver.chrome.driver",
					"/Users/bharatkammakatla/TestAutomation/SeleniumJavaFramework/src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		} else if (browserName == "firefox") {
			System.setProperty("webdriver.gecko.driver",
					"/Users/bharatkammakatla/TestAutomation/SeleniumJavaFramework/src/main/resources/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		} else if (browserName == "ie") {
			System.setProperty("webdriver.ie.driver",
					"/Users/bharatkammakatla/TestAutomation/SeleniumJavaFramework/src/main/resources/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
		} else {
			System.out.println(browserName + " is not a valid browser");
		}

	}

}
