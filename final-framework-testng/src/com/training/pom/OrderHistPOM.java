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
	
	
	public String OrderDetailsInfo() {
		return this.OrderDetails.getText();
	}
	
	public void ClickOrderHistory() {
		this.OrderHistory.click(); 
	}

	public void ClickOrderView() {
		this.OrderView.click(); 
	}
	
	
}

