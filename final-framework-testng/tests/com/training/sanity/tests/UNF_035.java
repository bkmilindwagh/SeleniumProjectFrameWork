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
import com.training.pom.AdminLoginPOM;
import com.training.pom.CartPOM;
import com.training.pom.CatelogPOM;
import com.training.pom.DatePOM;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.pom.ProdAttrPOM;
import com.training.pom.ProdDataPOM;
import com.training.pom.ProdDiscPOM;
import com.training.pom.ProdGenPOM;
import com.training.pom.ProdLinksPOM;
import com.training.pom.ProdRewardPOM;
import com.training.pom.ProductPOM;
import com.training.pom.StorePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_035 {

	private WebDriver driver;

	private String adminUrl;
	private LoginPOM loginPOM;
	private AcctInfoPOM acctInfoPOM;
	private PasswordPOM passwordPOM;
	private StorePOM storePOM;
	private CartPOM cartPOM;
	private ProductPOM productPOM;
	private AdminLoginPOM adminLoginPOM;

	private ProdGenPOM prodGenPOM;
	private ProdDataPOM prodDataPOM;
	private ProdLinksPOM prodLinksPOM;
	private CatelogPOM catelogPOM;
	private ProdDiscPOM prodDiscPOM;
	private ProdAttrPOM prodAttrPOM;
	private ProdRewardPOM prodRewardPOM;
	private DatePOM datePOM;


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
		catelogPOM = new CatelogPOM(driver);
		productPOM = new ProductPOM(driver);
		adminLoginPOM = new AdminLoginPOM(driver);
		prodGenPOM = new ProdGenPOM(driver);
		prodDataPOM = new ProdDataPOM(driver);
		prodLinksPOM = new ProdLinksPOM(driver);
		prodDiscPOM = new ProdDiscPOM(driver);
		prodAttrPOM = new ProdAttrPOM(driver);
		prodRewardPOM = new ProdRewardPOM(driver);
		datePOM = new DatePOM(driver);

		adminUrl = properties.getProperty("adminUrl");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void AdminAddProduct() throws InterruptedException {


		adminLoginPOM.sendadminUserName("admin");
		loginPOM.sendPassword("admin@123");
		adminLoginPOM.clickadminLoginBtn();
		catelogPOM.clickCatalog();

		productPOM.clickProducts();
		productPOM.clickaddNew();

		prodGenPOM.sendinputname("Blazer Girls(Y2020)(15-16)");
		prodGenPOM.sendinputTitle("Blazer for GirlsT");

		prodDataPOM.clickDataTab();
		prodDataPOM.sendinputModel("BLG-786");
		prodDataPOM.sendinputPrice("10");
		prodDataPOM.sendinputQuantity("100");

		prodLinksPOM.clickLinkTab();
		prodLinksPOM.clickLinkCategory();
		prodLinksPOM.sendLinkCategory("s");
		prodLinksPOM.clickCategoryDropdown();

		prodDiscPOM.clickDiscountTab();
		prodDiscPOM.clickAddDiscount();
		prodDiscPOM.sendDiscountQty("10");
		prodDiscPOM.sendiDiscountPrice("101");


		datePOM.clickstartDate();
		Thread.sleep(5000);
		datePOM.clicktodaysDate();
		datePOM.clickendDate();
		Thread.sleep(5000);
		datePOM.clickendDateNextDay();
		

		prodRewardPOM.clickRewardTab();
		prodRewardPOM.sendPoints("20");

		productPOM.clickProductSubmit();
		productPOM.getProdSubmitSccessMessage();
		
		String ActualResults = productPOM.getProdSubmitSccessMessage();
		String ExpectedResults = "Success";
		System.out.println(ActualResults);
		Assert.assertTrue(ActualResults.contains(ExpectedResults));

	}
}
