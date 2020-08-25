package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcctInfoPOM {

	private WebDriver driver; 

	public AcctInfoPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-firstname")
	private WebElement firstname;

	@FindBy(id="input-lastname")
	private WebElement lastname;

	@FindBy(id="input-email")
	private WebElement email;

	@FindBy(id="input-telephone")
	private WebElement telephone;

	@FindBy(id="input-fax")
	private WebElement fax;

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueBtn;

	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement SuccessMessage;

	@FindBy(linkText="Edit Account")
	private WebElement EditAccount;

	public void clickEditAccount() {
		this.EditAccount.click(); 
	}

	public void sendfirstName(String firstName) {
		this.firstname.clear();
		this.firstname.sendKeys(firstName);
	}

	public void sendlastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}

	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void sendtelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}

	public void sendfax(String fax) {
		this.fax.clear();
		this.fax.sendKeys(fax);
	}

	public void clickContinueBtn() {
		this.ContinueBtn.click(); 
	}

	public String ContinueSuccessMessage() {
		return this.SuccessMessage.getText();
	}

}
