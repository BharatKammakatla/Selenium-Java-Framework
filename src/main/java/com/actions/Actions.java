package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Actions {
	
	WebDriver driver;
	
	public Actions(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		element.click();
	}
	
	public void enterText(WebElement inputfield, String value) {
		inputfield.sendKeys(value);
	}
	
	public void navigateTo(String url) {
		driver.get(url);
		
	}
	
	public void selectFromDropdown(WebElement dropdown, String value) {
		Select dd = new Select(dropdown);
		dd.selectByValue(value);
	}

}
