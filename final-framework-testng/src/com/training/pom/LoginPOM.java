package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 

	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//WebElements
	@FindBy(id="input-email")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccount;

	@FindBy(linkText="Login")
	private WebElement MyAccountLogin;

	
	//Login Methods
	
	public void ClickMyAccount() {
		Actions act = new Actions(driver);
		act.moveToElement(this.MyAccount).build().perform();
		this.MyAccount.click();
	}

	public void ClickMyAccountLogin() {
		Actions act = new Actions(driver);
		act.moveToElement(this.MyAccountLogin).build().perform();
		this.MyAccountLogin.click();
	}

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

}
