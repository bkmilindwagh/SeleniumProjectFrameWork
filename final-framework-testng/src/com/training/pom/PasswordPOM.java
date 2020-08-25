package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPOM {
	private WebDriver driver; 
	public PasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Password")
	private WebElement changePassword;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	public void ClickchangePassword() {
		this.changePassword.click();
	
	}
	
	public void sendConfrimPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
}
