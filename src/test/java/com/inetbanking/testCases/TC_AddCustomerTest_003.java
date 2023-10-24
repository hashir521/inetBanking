package com.inetbanking.testCases;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.LoginPage;
public class TC_AddCustomerTest_003 extends BaseClass{
	public static Logger logger;
	
	@Test()
	public void addNewCustomer() throws InterruptedException, IOException {
		
		
		driver.get(baseUrl);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		//Thread.sleep(3000);
		
		AddCustomerPage a = new AddCustomerPage(driver);
		a.clickAddNewCustomer();
		a.CustomerName("hashir");
		a.CustomerGendeer("male");
		a.CustomerDOB("10", "15", "1998");
		Thread.sleep(3000);
		a.CustomerAddress("Pakistan");
		a.CustomerCity("karachi");
		a.CustomerState("Sindh");
		a.CustomerPinNo("123456");
		a.CustomerTelephone("03101116374");
		String email = randomString()+"@gmail.com";
		a.CustomerEmail(email);
		a.CustomerPassword("123456");
		a.CustomerSubmitBtn();
		Thread.sleep(3000);
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			
		}
		else {
			captureScreen(driver, "addNewCustomer");

			Assert.assertTrue(false);
		}
	}

}
