package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookAppointmentPage {
	
	public WebDriver driver;
	
	public BookAppointmentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// All objects should be defined here
	By title = By.cssSelector("h2");
	By facilityDD = By.cssSelector("select[id=combo_facility]");
	By readmission = By.cssSelector("input[id=chk_hospotal_readmission]");
	By medicaid = By.cssSelector("input[id=radio_program_medicaid]");
	By visitDate = By.cssSelector("input[id=txt_visit_date]");
	By comment = By.cssSelector("textarea[id=txt_comment]");
	By bookBtn = By.cssSelector("button[id=btn-book-appointment]");
	
	// All methods should be defined here
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getFacilityDD() {
		return driver.findElement(facilityDD);
	}
	public WebElement getReadmission() {
		return driver.findElement(readmission);
	}
	public WebElement getMedicaid() {
		return driver.findElement(medicaid);
	}
	public WebElement getVisitDate() {
		return driver.findElement(visitDate);
	}
	public WebElement getComment() {
		return driver.findElement(comment);
	}
	public WebElement getBookBtn() {
		return driver.findElement(bookBtn);
	}

}
