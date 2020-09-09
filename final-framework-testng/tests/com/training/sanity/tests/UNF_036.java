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
import com.training.pom.CartPOM;
import com.training.pom.LoginPOM;
import com.training.pom.OrderHistPOM;
import com.training.pom.PasswordPOM;
import com.training.pom.PaymentDetailPOM;
import com.training.pom.StorePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_036 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AcctInfoPOM acctInfoPOM;
	private PasswordPOM passwordPOM;
	private StorePOM storePOM;
	private CartPOM cartPOM;
	private PaymentDetailPOM paymentDetailPOM;
	private OrderHistPOM orderHistPOM;
	
	
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
		storePOM = new StorePOM(driver);
		cartPOM = new CartPOM(driver);
		paymentDetailPOM = new PaymentDetailPOM(driver);
		orderHistPOM = new OrderHistPOM(driver);
		
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
	public void UserReturnsOrder() throws InterruptedException {
		
					
		//Login
		loginPOM.ClickMyAccount();
		loginPOM.ClickMyAccountLogin();
		loginPOM.sendUserName("milind@gmail.com");
		loginPOM.sendPassword("password1$");
		loginPOM.clickLoginBtn(); 
		
	
		loginPOM.ClickMyAccount();
		orderHistPOM.ClickOrderHistory();
		orderHistPOM.ClickOrderView();
		orderHistPOM.ClickReturn();
		
		orderHistPOM.ClickReasonRetunBtn();
		orderHistPOM.ClickRetunOpenProduct();
		orderHistPOM.sendComment("NO SPECIFIC PRODUCT");
		paymentDetailPOM.CheckreadPolicy();
		orderHistPOM.ClickSubmitBtn();
		
		orderHistPOM.getReturnProdSccessMessage();
		String ActualResults = orderHistPOM.getReturnProdSccessMessage();
		String ExpectedResults = "Thank you for submitting your return request";
		System.out.println(ActualResults);
		Assert.assertTrue(ActualResults.contains(ExpectedResults));
	
		
	}
}
