package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM {
	private WebDriver driver; 
	public ProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Products")
	private WebElement Products;

	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addNew;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement ProductSubmit;	
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ProdSubmitSccessMessage;	
	
		
	public void clickProducts() {
		Actions act = new Actions(driver);
		act.moveToElement(this.Products).build().perform();
		this.Products.click();
	}

	public void clickaddNew() {
		this.addNew.click(); 
	}
	
	public void clickProductSubmit() {
		this.ProductSubmit.click(); 
	}

	public String getProdSubmitSccessMessage() {
		return this.ProdSubmitSccessMessage.getText();
	}
}

