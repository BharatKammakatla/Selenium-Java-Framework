package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// All objects should be defined here
	By menuBtn = By.cssSelector("a[id='menu-toggle']");
	By login = By.cssSelector("a[href*='login']");
	By title = By.cssSelector("h1");
	By footer = By.cssSelector("footer");
	
	
	// All methods should be defined here
	public WebElement getMenuBtn() {
		return driver.findElement(menuBtn);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getFooter() {
		return driver.findElement(footer);
	}

}
