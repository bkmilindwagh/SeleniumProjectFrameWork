package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPOM {

	private WebDriver driver; 

	public CartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//div[@id='cart']")
	private WebElement Cart;


	@FindBy(xpath = "//a[@href='http://uniformm1.upskills.in/index.php?route=checkout/checkout']")
	private WebElement CheckOutCart;

	@FindBy(name="account")
	private WebElement Guest;

	@FindBy(id="button-account")
	private WebElement GuestContinue;


	@FindBy(xpath = "//div[@id='content']/p[.='Your order has been successfully processed!']")
	private WebElement confirmOrderMessage;

	@FindBy(xpath = "//p[contains(text(),'Your shopping cart is empty!')]")
	private WebElement emptyCartMessage;


	public String getconfirmOrderMessage() {
		return this.confirmOrderMessage.getText();
	}

	public String getemptyCartMessage() {
		Actions act = new Actions(driver);
		act.moveToElement(emptyCartMessage).build().perform();
		return this.emptyCartMessage.getText();
	}


	public void ClickCart() throws InterruptedException {
		this.Cart.click();
	}

	public void ClickCheckOutCart() {
		//Actions act = new Actions(driver);
		//act.moveToElement(CheckOutCart).click().perform();
		//this.ClickCheckOutCart();
		this.CheckOutCart.click();
	}

	public void SelectGuestBtn() {
		this.Guest.click();
	}
	public void ClickGuestContinue() {
		this.GuestContinue.click();
	}

}
