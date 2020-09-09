package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProdLinksPOM {
	private WebDriver driver; 
	public ProdLinksPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Links")
	private WebElement LinkTab;

	@FindBy(id="input-category")
	private WebElement Category;

	@FindBy(xpath="//li[@data-value='655']")
	private WebElement CategoryDropdown;

	
	

	public void clickLinkTab() {
		Actions act = new Actions(driver);
		act.moveToElement(this.LinkTab).build().perform();
		this.LinkTab.click();
	}

	
	
	public void clickLinkCategory() {
		Actions act = new Actions(driver);
		act.moveToElement(this.Category).build().perform();
		this.Category.click();
	}
	
	public void sendLinkCategory(String inputTitle) {
		this.Category.clear(); 
		this.Category.sendKeys(inputTitle); 
	}

	
	public void clickCategoryDropdown() {
		this.CategoryDropdown.click(); 
	}
	


}
