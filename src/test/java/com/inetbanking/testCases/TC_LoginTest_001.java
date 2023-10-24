package com.inetbanking.testCases;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	public static Logger logger;
	@Test
	public void LoginTest() throws IOException {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.setPassword(password);
		
		lp.clickLoginBtn();
		
		if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")) {
			Assert.assertTrue(true);

		}
		else {
			captureScreen(driver, "LoginTest");
		Assert.assertFalse(false);		

		}
		
	}

}
