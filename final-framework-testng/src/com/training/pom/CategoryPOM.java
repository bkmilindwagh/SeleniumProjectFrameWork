package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPOM {
	
	private WebDriver driver; 
	public CategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="Categories")
	private WebElement Categories;
	
	@FindBy(xpath="//div[@id='language1']/div[2]//div[@class='note-editable panel-body']")
	private WebElement CategDescription;
	
	@FindBy(id="input-meta-title1")
	private WebElement MetaTagtitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement MetaTagdescription;
	

	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement SaveBtn;
	
	
		
	public void clickCategories() {
		Actions act = new Actions(driver);
		act.moveToElement(this.Categories).build().perform();
		this.Categories.click();
	}
	
	
	public void sendCategDescription(String CategDescription) {
		this.CategDescription.clear(); 
		this.CategDescription.sendKeys(CategDescription); 
	}
	
	public void sendMetaTagtitle(String MetaTagtitle) {
		this.MetaTagtitle.clear(); 
		this.MetaTagtitle.sendKeys(MetaTagtitle); 
	}
	
	public void sendMetaTagdescription(String MetaTagdescription) {
		this.MetaTagdescription.clear(); 
		this.MetaTagdescription.sendKeys(MetaTagdescription); 
	}
	
	public void clickSaveBtn() {
		this.SaveBtn.click(); 
	}
		
}
