package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatelogPOM {

	private WebDriver driver; 

	public CatelogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement Catalog;

	
		
	public void clickCatalog() {
		Actions act = new Actions(driver);
		act.moveToElement(this.Catalog).build().perform();
		this.Catalog.click();
	}
	
		
}
