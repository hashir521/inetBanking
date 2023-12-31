package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;



public class BaseClass {
	ReadConfig r = new ReadConfig();
	String baseUrl = r.getApplicationUrl();
	String userName = r.getUserName();
	String password = r.getPassword();
	public static WebDriver driver; 
//	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		//driver.get(baseUrl);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
}
