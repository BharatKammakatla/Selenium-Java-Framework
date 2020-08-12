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
	private By title = By.cssSelector("h2");
	private By facilityDD = By.cssSelector("select[id=combo_facility]");
	private By readmission = By.cssSelector("input[id=chk_hospotal_readmission]");
	private By medicaid = By.cssSelector("input[id=radio_program_medicaid]");
	private By visitDate = By.cssSelector("input[id=txt_visit_date]");
	private By comment = By.cssSelector("textarea[id=txt_comment]");
	private By bookBtn = By.cssSelector("button[id=btn-book-appointment]");
	
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
