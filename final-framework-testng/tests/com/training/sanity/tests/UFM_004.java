
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
import com.training.pom.LoginPOM;
import com.training.pom.OrderHistPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_004  {private WebDriver driver;
private String baseUrl;
private LoginPOM loginPOM;
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
public void validOrderHistTest() throws InterruptedException {

	//Login
	loginPOM.ClickMyAccount();
	loginPOM.ClickMyAccountLogin();
	loginPOM.sendUserName("milind@gmail.com");
	loginPOM.sendPassword("password1$");
	loginPOM.clickLoginBtn(); 

	//UFM004: To Verify whether application displays order details upon Clicking My Orders link
	orderHistPOM.ClickOrderHistory();
	orderHistPOM.ClickOrderView();

	//Assertion on Success message
	String ActualResults = orderHistPOM.OrderDetailsInfo();
	String ExpectedResults = "Order Details";
	Assert.assertEquals(ActualResults, ExpectedResults);
}

}

