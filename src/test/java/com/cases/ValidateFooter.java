package com.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.Actions;
import com.base.Base;
import com.pageObjects.HomePage;

public class ValidateFooter extends Base {
	
	public WebDriver driver;
	public Actions actions;
	
	private Logger log = LogManager.getLogger(ValidateFooter.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		actions = new Actions(driver);
		actions.navigateTo(prop.getProperty("url"));
	}
	
	@Test
	public void checkFooter() throws IOException {

		HomePage hp = new HomePage(driver);
		
		Assert.assertTrue(hp.getFooter().isDisplayed());
		log.info("Footer is displayed");

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
