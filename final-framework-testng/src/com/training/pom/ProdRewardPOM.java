package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdRewardPOM {

	private WebDriver driver; 
	public ProdRewardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Reward Points")
	private WebElement RewardTab;
	
	@FindBy(id="input-points")
	private WebElement Points;
	
		
public void clickRewardTab() {
		Actions act = new Actions(driver);
		act.moveToElement(this.RewardTab).build().perform();
		this.RewardTab.click();
	}

public void sendPoints(String Points) {
	this.Points.clear(); 
	this.Points.sendKeys(Points); 
}

}
