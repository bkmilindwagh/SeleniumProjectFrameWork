package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdAttrPOM {

	private WebDriver driver; 
	public ProdAttrPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Attribute")
	private WebElement attributeTab;
	
	@FindBy(xpath="//table[@id='attribute']//button/i[@class='fa fa-plus-circle']")
	private WebElement AddAttriBtn;
	
	public void clickattributeTab() {
		Actions act = new Actions(driver);
		act.moveToElement(this.attributeTab).build().perform();
		this.attributeTab.click();
	}
	
	public void clickAddAttriBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(this.AddAttriBtn).build().perform();
		this.AddAttriBtn.click();
	}

}
