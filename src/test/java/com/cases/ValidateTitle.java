package com.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.Actions;
import com.base.Base;
import com.pageObjects.HomePage;

public class ValidateTitle extends Base {
	
	public WebDriver driver;
	Actions actions;
	
	private Logger log = LogManager.getLogger(Login.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		actions = new Actions(driver);
		actions.navigateTo(prop.getProperty("url"));
	}

	@Test
	public void checkTitle() throws IOException {


		HomePage hp = new HomePage(driver);

		String actualTitle = hp.getTitle().getText();
		String expectedTitle = "CURA Healthcare";

		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("Successfully validated Title");

	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
