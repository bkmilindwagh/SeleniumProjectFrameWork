package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StorePOM {
	private WebDriver driver; 

	public StorePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	@FindBy(linkText="Uniform Store")
	private WebElement UniformStore;

	@FindBy(linkText="REGULAR T-SHIRTS (Rust)")
	private WebElement TShirtRust;

	@FindBy(id="input-option376")
	private WebElement ChestSizeDropDown;

	@FindBy(id="button-cart")
	private WebElement AddToCart;


	public void clickUniformStore() {
		this.UniformStore.click(); 
	}



	@FindBy(xpath="//div[@id='content']/div[@class='alert alert-success']")
	private WebElement AddToCartSuccessMessage;

	@FindBy(xpath="//h1[contains(.,'Your order has been placed!')]")
	private WebElement CartSuccessMessage;



	public String getAddToCartSuccessMessage() {
		return this.AddToCartSuccessMessage.getText();
	}


	public void clickTShirtRust() {
		Actions act = new Actions(driver);
		act.moveToElement(this.TShirtRust).build().perform();
		this.TShirtRust.click();
	}

	
	public void clickAddToCart() {
		this.AddToCart.click(); 
	}

	public void clickChestSizeDropDown() {
		Select dropdown = new Select(driver.findElement(By.id("input-option376")));  
		dropdown.selectByIndex(2);

	}

}
