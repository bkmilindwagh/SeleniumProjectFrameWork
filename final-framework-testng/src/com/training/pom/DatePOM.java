package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePOM {
	private WebDriver driver; 

	public DatePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//td[5]/div/span[@class='input-group-btn']/button[@type='button']")
	private WebElement startDate;

	@FindBy(xpath="//div[5]//div[@class='datepicker-days']/table[@class='table-condensed']//td[@class='day active today']")
	private WebElement todaysDate;
	
		
	@FindBy(xpath="//td[6]/div/span[@class='input-group-btn']/button[@type='button']")
	
	private WebElement endDate;
	
	@FindBy(xpath="//div[6]//div[@class='datepicker-days']/table[@class='table-condensed']//td[@class='day active today']//following-sibling::td[1]")
	
	private WebElement endDateNextDay;

	
	
	
	public void clickstartDate() {
		Actions act = new Actions(driver);
		act.moveToElement(this.startDate).build().perform();
		this.startDate.click();
	}
	
	public void clicktodaysDate() {
		this.todaysDate.click();
	}
	
	public void clickendDate() {
		Actions act = new Actions(driver);
		act.moveToElement(this.endDate).build().perform();
		this.endDate.click();
	}
	
	public void clickendDateNextDay() {
		this.endDateNextDay.click();
	}
	
}
