package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AcctInfoPOM;
import com.training.pom.CartPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.pom.PaymentDetailPOM;
import com.training.pom.StorePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_034 {
  
	
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	//private AcctInfoPOM acctInfoPOM;
	//private PasswordPOM passwordPOM;
	private StorePOM storePOM;
	private CartPOM cartPOM;
	private PaymentDetailPOM paymentDetailPOM;
	
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
		//loginPOM = new LoginPOM(driver); 
		//acctInfoPOM = new AcctInfoPOM(driver);
		//passwordPOM = new PasswordPOM(driver);
		storePOM = new StorePOM(driver);
		cartPOM = new CartPOM(driver);
		paymentDetailPOM = new PaymentDetailPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void guestUserOrder() throws InterruptedException {
		
					
		//UFM006:
	storePOM.clickUniformStore();
	storePOM.clickTShirtRust();
	storePOM.clickChestSizeDropDown();
	storePOM.clickAddToCart();
	
	storePOM.getAddToCartSuccessMessage();
	String ActualResults = storePOM.getAddToCartSuccessMessage();
	String ExpectedResults = "Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!";
	Assert.assertTrue(ActualResults.contains(ExpectedResults));
	
	//Cart
	cartPOM.ClickCart();
	cartPOM.ClickCheckOutCart();
	cartPOM.SelectGuestBtn();
	cartPOM.ClickGuestContinue();
	
	//Payment Information
	paymentDetailPOM.EnterPaymentfirstname("mil");
	paymentDetailPOM.EnterPaymentlastname("wagh");
	paymentDetailPOM.EnterPaymentemail("mili10@gmail.com");
	paymentDetailPOM.EnterPaymenttelephone("111111111");
	paymentDetailPOM.EnterPaymentaddress("IndiraNagar");
	paymentDetailPOM.EnterPaymentcity("Nashik");
	paymentDetailPOM.EnterPaymentpostcode("422009");
	paymentDetailPOM.EnterPaymentpassword("password1$");
	paymentDetailPOM.EnterPaymentpasswordconfirm("password1$");
	paymentDetailPOM.SelectPaymentCountry();
	paymentDetailPOM.SelectPaymentZone();
	Thread.sleep(2000);
	paymentDetailPOM.CheckreadPolicy();
	paymentDetailPOM.ClickPayment();
	paymentDetailPOM.ClickShippingAddress();
	paymentDetailPOM.Entercommenttext("Don't give parcel to my Wife, give it to me");
	paymentDetailPOM.ClickcommentContinue();
	Thread.sleep(2000);
	paymentDetailPOM.CheckreadPolicy();
	paymentDetailPOM.ClickpaymentContinue();
	paymentDetailPOM.ClickConfirmBtn();
	
	String ActualResults1 = cartPOM.getconfirmOrderMessage();
	String ExpectedResults1 = "Your order has been successfully processed!";
	Assert.assertTrue(ActualResults1.contains(ExpectedResults1));
	
	cartPOM.ClickCart();
	
	System.out.println("Your order has been successfully processed!");
	
	String ActualResults2 = cartPOM.getemptyCartMessage();
	String ExpectedResults2 = "Your shopping cart is empty!";
	System.out.println(ActualResults2);
	Assert.assertTrue(ActualResults2.contains(ExpectedResults2));
	

	}
}
