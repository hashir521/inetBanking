package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException {
		driver.get(baseUrl);
		LoginPage l = new LoginPage(driver);
		//LoginPage lp = new LoginPage(driver);
		l.setUserName(userName);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		l.setPassword(password);
		
		l.clickLoginBtn();
		
		if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")) {
			Assert.assertTrue(true);

		}
		else {
			captureScreen(driver, "LoginTest");
		Assert.assertFalse(false);		

		}
		
	}
}
