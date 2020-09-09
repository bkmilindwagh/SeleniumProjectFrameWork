package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentDetailPOM {
	private WebDriver driver; 
	public PaymentDetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="input-payment-firstname")
	private WebElement Paymentfirstname;

	@FindBy(id="input-payment-lastname")
	private WebElement Paymentlastname;

	@FindBy(id="input-payment-email")
	private WebElement Paymentemail;

	@FindBy(id="input-payment-telephone")
	private WebElement Paymenttelephone;

	@FindBy(id="input-payment-address-1")
	private WebElement Paymentaddress;

	@FindBy(id="input-payment-city")
	private WebElement Paymentcity;

	@FindBy(id="input-payment-postcode")
	private WebElement Paymentpostcode;

	@FindBy(id="input-payment-password")
	private WebElement Paymentpassword;

	@FindBy(id="input-payment-confirm")
	private WebElement Paymentpasswordconfirm;

	@FindBy(id="button-register")
	private WebElement Paymentregister;

	@FindBy(id="button-shipping-address")
	private WebElement shippingaddress;

	@FindBy(name="comment")
	private WebElement commentText;
	
	@FindBy(id="button-shipping-method")
	private WebElement commentContinue;
	
	@FindBy(id="button-payment-method")
	private WebElement paymentContinue;
	
	
	@FindBy(id="button-confirm")
	private WebElement ConfirmBtn;
	
			
	
	public void Entercommenttext(String commentText) {
		this.commentText.clear();
		this.commentText.sendKeys(commentText);
	}

	public void EnterPaymentfirstname(String Paymentfirstname) {
		this.Paymentfirstname.clear();
		this.Paymentfirstname.sendKeys(Paymentfirstname);
	}

	public void EnterPaymentlastname(String Paymentlastname) {
		this.Paymentlastname.clear();
		this.Paymentlastname.sendKeys(Paymentlastname);
	}

	public void EnterPaymentemail(String Paymentemail) {
		this.Paymentemail.clear();
		this.Paymentemail.sendKeys(Paymentemail);
	}

	public void EnterPaymenttelephone(String Paymenttelephone) {
		this.Paymenttelephone.clear();
		this.Paymenttelephone.sendKeys(Paymenttelephone);
	}

	public void EnterPaymentaddress(String Paymentaddress) {
		this.Paymentaddress.clear();
		this.Paymentaddress.sendKeys(Paymentaddress);
	}

	public void EnterPaymentcity(String Paymentcity) {
		this.Paymentcity.clear();
		this.Paymentcity.sendKeys(Paymentcity);
	}

	public void EnterPaymentpostcode(String Paymentpostcode) {
		this.Paymentpostcode.clear();
		this.Paymentpostcode.sendKeys(Paymentpostcode);
	}

	public void EnterPaymentpassword(String Paymentpassword) {
		this.Paymentpassword.clear();
		this.Paymentpassword.sendKeys(Paymentpassword);
	}

	public void EnterPaymentpasswordconfirm(String Paymentpasswordconfirm) {
		this.Paymentpasswordconfirm.clear();
		this.Paymentpasswordconfirm.sendKeys(Paymentpasswordconfirm);
	}

	public void SelectPaymentCountry() {
		Select dropdown = new Select(driver.findElement(By.id("input-payment-country")));  
		dropdown.selectByVisibleText("India");
	}	

	public void SelectPaymentZone() {
		Select dropdown = new Select(driver.findElement(By.id("input-payment-zone"))); 
		dropdown.selectByVisibleText("Maharashtra");

	}	
	public void CheckreadPolicy() {
		WebElement ChkreadPolicy=driver.findElement(By.name("agree"));
		ChkreadPolicy.click();
	}

	public void ClickPayment() {
		this.Paymentregister.click(); 
	}

	public void ClickShippingAddress() {
		this.shippingaddress.click(); 
	}

	public void ClickcommentContinue() {
		this.commentContinue.click(); 
	}
	
	public void ClickpaymentContinue() {
		this.paymentContinue.click(); 
	}
	
	
	public void ClickConfirmBtn() {
		this.ConfirmBtn.click(); 
	}
}
