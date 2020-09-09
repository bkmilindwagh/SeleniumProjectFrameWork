package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdDataPOM {
	private WebDriver driver; 
	public ProdDataPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Data")
	private WebElement dataTab;

	@FindBy(id="input-model")
	private WebElement inputModel;

	@FindBy(id="input-price")
	private WebElement inputPrice;

	@FindBy(id="input-quantity")
	private WebElement inputQuantity;

	public void sendinputModel(String inputModel) {
		this.inputModel.clear(); 
		this.inputModel.sendKeys(inputModel); 
	}

	public void sendinputPrice(String inputPrice) {
		this.inputPrice.clear(); 
		this.inputPrice.sendKeys(inputPrice); 
	}

	public void sendinputQuantity(String inputQuantity) {
		this.inputQuantity.clear(); 
		this.inputQuantity.sendKeys(inputQuantity); 
	}

	public void clickDataTab() {
		Actions act = new Actions(driver);
		act.moveToElement(this.dataTab).build().perform();
		this.dataTab.click();
	}
}
