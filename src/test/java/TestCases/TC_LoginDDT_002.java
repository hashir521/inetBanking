package TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import utilities.XLUtility;



public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLoginBtn();
		
		Thread.sleep(3000);
		captureScreen(driver, "loginDDT");
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();//close aleart
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogOutBtn();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		//String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		String path = System.getProperty("user.dir")+"/src/test/java/testData/LoginData.xlsx";
		XLUtility x = new XLUtility(path);
		
		int rownum = x.getRowCount("Sheet1");
		int colcount = x.getCellCount("Sheet1",1);
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j] = x.getCellData("Sheet1",i, j);
			}
		}
		return logindata;
		
	}
}
