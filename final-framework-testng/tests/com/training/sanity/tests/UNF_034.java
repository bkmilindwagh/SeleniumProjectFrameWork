package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AcctInfoPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_034 {
  
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AcctInfoPOM acctInfoPOM;
	private PasswordPOM passwordPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		acctInfoPOM = new AcctInfoPOM(driver);
		passwordPOM = new PasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validPassowrdTest() throws InterruptedException {
		
		/*/Login into application
		loginPOM.ClickMyAccount();
		loginPOM.ClickMyAccountLogin();
		loginPOM.sendUserName("milind@gmail.com");
		loginPOM.sendPassword("password1$");
		loginPOM.clickLoginBtn(); */
		
		
			
		//UFM006: To verify whether application allows user to change the password in Change Your Password page
		passwordPOM.ClickchangePassword();
		loginPOM.sendPassword("password1$");
		passwordPOM.sendConfrimPassword("password1$");
		acctInfoPOM.clickContinueBtn();
		
		//Assertion on Success message
		String ActualResults = acctInfoPOM.ContinueSuccessMessage();
		String ExpectedResults = "Success: Your password has been successfully updated.";
		Assert.assertEquals(ActualResults, ExpectedResults);
		
	}
	
	
	
}
