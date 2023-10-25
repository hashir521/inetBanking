package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	By userName = By.name("uid");
	By password = By.name("password");
	By loginBtn = By.name("btnLogin");
	By logOut = By.linkText("Log out");
	//By logOut = By.xpath("1");
	
	public LoginPage(WebDriver d) {
		driver = d;
	}
	public void setUserName(String uname) {
		driver.findElement(userName).sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}

	public void clickLogOutBtn() {
		driver.findElement(logOut).click();
	}
}
