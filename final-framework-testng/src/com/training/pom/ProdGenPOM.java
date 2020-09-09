package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdGenPOM {
	
	private WebDriver driver; 
	public ProdGenPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-name1")
	private WebElement inputname;
	
	@FindBy(id="input-meta-title1")
	private WebElement inputTitle;
	
	public void sendinputname(String inputname) {
		this.inputname.clear(); 
		this.inputname.sendKeys(inputname); 
	}
	
	public void sendinputTitle(String inputTitle) {
		this.inputTitle.clear(); 
		this.inputTitle.sendKeys(inputTitle); 
	}

}
