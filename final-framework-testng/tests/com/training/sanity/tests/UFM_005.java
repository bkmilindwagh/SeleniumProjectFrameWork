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

import com.training.generics.ScreenShot;
import com.training.pom.AcctInfoPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_005 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AcctInfoPOM acctInfoPOM;
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
	public void validMyAccountTest() throws InterruptedException {
		
		//Login
		loginPOM.ClickMyAccount();
		loginPOM.ClickMyAccountLogin();
		loginPOM.sendUserName("milind@gmail.com");
		loginPOM.sendPassword("password1$");
		loginPOM.clickLoginBtn(); 
			
		//UFM005: To verify whether application allows user to modify the details  in Your Personal Details Page		
		acctInfoPOM.clickEditAccount();
		acctInfoPOM.sendfirstName("milind1");
		acctInfoPOM.sendlastname("wagh");
		acctInfoPOM.sendemail("milind@gmail.com");
		acctInfoPOM.sendtelephone("111111111");
		acctInfoPOM.sendfax("111111111");
		acctInfoPOM.clickContinueBtn();
		
		//Assertion on Success message
		String ActualResults = acctInfoPOM.ContinueSuccessMessage();
		String ExpectedResults = "Success: Your account has been successfully updated.";
		Assert.assertEquals(ActualResults, ExpectedResults);
		
		
	}
	
}
