package com.cases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;

public class Login extends Base {
	
	public static Logger log = LogManager.getLogger(Login.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
	}

	@Test(dataProvider = "getData")
	public void performLogin(String username, String password) {
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);

		hp.getMenuBtn().click();
		hp.getLogin().click();

		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
		log.info("Successfully Logged In");

	}

	@DataProvider
	public Object[][] getData() {
		// Each row is set of test data for a test case
		// Each column is a value in a set of test data
		Object[][] data = new Object[2][2];

		// First set of test data
		data[0][0] = "testuser1";
		data[0][1] = "testpwd1";

		// Second set of test data
		data[1][0] = "testuser2";
		data[1][1] = "testpwd2";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
