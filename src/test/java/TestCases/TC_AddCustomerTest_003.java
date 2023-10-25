package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{
	@Test()
	public void addNewCustomer() throws InterruptedException, IOException {
		
		
		driver.get(baseUrl);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage l =new LoginPage(driver);
		l.setUserName(userName);
		l.setPassword(password);
		l.clickLoginBtn();
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
