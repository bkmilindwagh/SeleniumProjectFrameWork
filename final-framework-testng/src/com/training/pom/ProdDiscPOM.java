package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdDiscPOM {
	private WebDriver driver; 
	public ProdDiscPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Discount")
	private WebElement DiscountTab;

	@FindBy(xpath="//table[@id='discount']//button/i[@class='fa fa-plus-circle']")
	private WebElement AddDiscount;

	@FindBy(name="product_discount[0][quantity]")
	private WebElement DiscountQty;

	@FindBy(name="product_discount[0][price]")
	private WebElement DiscountPrice;

	@FindBy(name="product_discount[0][date_start]")
	private WebElement DiscountStartDt;

	@FindBy(name="product_discount[0][date_end]")
	private WebElement DiscountEndDt;


	public void clickDiscountTab() {
		Actions act = new Actions(driver);
		act.moveToElement(this.DiscountTab).build().perform();
		this.DiscountTab.click();
	}

	public void clickAddDiscount() {
		Actions act = new Actions(driver);
		act.moveToElement(this.AddDiscount).build().perform();
		this.AddDiscount.click();
	}

	public void sendDiscountQty(String DiscountQty) {
		this.DiscountQty.clear(); 
		this.DiscountQty.sendKeys(DiscountQty); 
	}

	public void sendiDiscountPrice(String DiscountPrice) {
		this.DiscountPrice.clear(); 
		this.DiscountPrice.sendKeys(DiscountPrice); 
	}

	public void sendDiscountStartDt(String DiscountStartDt) {
		this.DiscountStartDt.clear(); 
		this.DiscountStartDt.sendKeys(DiscountStartDt); 
	}

	public void sendDiscountEndDt(String DiscountEndDt) {
		this.DiscountEndDt.clear(); 
		this.DiscountEndDt.sendKeys(DiscountEndDt); 
	}
}
