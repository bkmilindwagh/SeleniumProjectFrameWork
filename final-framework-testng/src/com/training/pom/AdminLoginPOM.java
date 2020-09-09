package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {
	
	private WebDriver driver; 

	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	
}
	
	@FindBy(id="input-username")
	private WebElement adminUserName; 


	@FindBy(xpath="//button[@type='submit']")
	private WebElement adminLoginBtn;
	
	public void sendadminUserName(String adminUserName) {
		this.adminUserName.clear();
		this.adminUserName.sendKeys(adminUserName);
	}

		public void clickadminLoginBtn() {
		this.adminLoginBtn.click(); 
	}
}
