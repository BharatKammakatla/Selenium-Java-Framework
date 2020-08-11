package com.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageObjects.HomePage;

public class ValidateFooter extends Base {
	
	public static Logger log = LogManager.getLogger(ValidateFooter.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}
	
	@Test
	public void navigateToHomePage() throws IOException {

		HomePage hp = new HomePage(driver);

		AssertJUnit.assertTrue(hp.getFooter().isDisplayed());
		log.info("Footer is displayed");

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
