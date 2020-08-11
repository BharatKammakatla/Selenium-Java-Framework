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

public class ValidateTitle extends Base {
	
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

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

		String actualTitle = hp.getTitle().getText();
		String expectedTitle = "CURA Healthcare Service";

		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		log.info("Successfully validated Title");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
