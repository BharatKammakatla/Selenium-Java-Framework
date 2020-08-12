package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// All objects should be defined here
	private By username = By.cssSelector("input[name='username']");
	private By password = By.cssSelector("input[name='password']");
	private By loginBtn = By.cssSelector("button[id='btn-login']");
	
	// All methods should be defined here
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}


}
