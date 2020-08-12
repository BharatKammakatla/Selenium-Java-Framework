package com.cases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actions.Actions;
import com.base.Base;
import com.pageObjects.AppointmentConfPage;
import com.pageObjects.BookAppointmentPage;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;

public class BookAppointment extends Base {
	
	public WebDriver driver;
	Actions actions;
	
	private Logger log = LogManager.getLogger(BookAppointment.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		actions = new Actions(driver);
		log.info("Driver is initialized.");
	}

	@Test
	public void bookAppointment() {
		
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		BookAppointmentPage ba = new BookAppointmentPage(driver);
		AppointmentConfPage ac = new AppointmentConfPage(driver);
		
		actions.navigateTo(prop.getProperty("url"));
		actions.click(hp.getMenuBtn());
		actions.click(hp.getLogin());
		actions.enterText(lp.getUsername(), "John Doe");
		actions.enterText(lp.getPassword(), "ThisIsNotAPassword");
		actions.click(lp.getLoginBtn());
		//add a wait function
		actions.selectFromDropdown(ba.getFacilityDD(), "Hongkong CURA Healthcare Center");
		actions.click(ba.getReadmission());
		actions.click(ba.getMedicaid());
		actions.enterText(ba.getVisitDate(), "08/08/2020");
		actions.enterText(ba.getComment(), "Test message: Regular check up");
		actions.click(ba.getBookBtn());
		
		Assert.assertTrue(ac.getTitle().isDisplayed());

	}


	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
