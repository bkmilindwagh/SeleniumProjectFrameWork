package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistPOM {
	private WebDriver driver; 

	public OrderHistPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Order History")
	private WebElement OrderHistory;

	@FindBy(xpath="//table//a/i[@class='fa fa-eye']")
	private WebElement OrderView;

	@FindBy(xpath="//div[@id='content']/table[1]/thead/tr/td[@class='text-left']")
	private WebElement OrderDetails;

	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement ReturnProdBtn;

	@FindBy(xpath="//label[contains(.,'Order Error')]")
	private WebElement ReasonRetunBtn;

	@FindBy(xpath="//label[contains(.,'Yes')]")
	private WebElement RetunOpenProduct;

	@FindBy(id="input-comment")
	private WebElement Comment;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement SumbitBtn;
	
	@FindBy(xpath="//p[contains(.,'Thank you for submitting your return request. Your request has been sent to the relevant department for processing.')]")
	private WebElement ReturnProdSccessMessage;

	public String OrderDetailsInfo() {
		return this.OrderDetails.getText();
	}

	public void ClickOrderHistory() {
		this.OrderHistory.click(); 
	}

	public void ClickOrderView() {
		this.OrderView.click(); 
	}

	public void ClickReturn() {
		this.ReturnProdBtn.click(); 
	}

	public void ClickReasonRetunBtn() {
		this.ReasonRetunBtn.click(); 
	}

	public void ClickRetunOpenProduct() {
		this.RetunOpenProduct.click(); 
	}

	public void sendComment(String Category) {
		this.Comment.clear(); 
		this.Comment.sendKeys(Category); 
	}
	
	public void ClickSubmitBtn() {
		this.SumbitBtn.click();
	}
	
	
	public String getReturnProdSccessMessage() {
		return this.ReturnProdSccessMessage.getText();
	}
	
	
	
}

