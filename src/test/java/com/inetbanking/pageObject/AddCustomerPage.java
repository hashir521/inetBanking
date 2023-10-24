package com.inetbanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {
	WebDriver driver;
	public AddCustomerPage(WebDriver d) {
		
		driver = d;
	}
	
	By addNewCustomerr = By.partialLinkText("New Custom");
	//By addNewCustomer = By.cssSelector("body");
	By CustomerName = By.name("name");
	By gender = By.name("rad1");
	By Dob = By.name("dob");
	By address = By.name("addr");
	By city = By.name("city");
	By state = By.name("state");
	By pinno = By.name("pinno");
	By telephone = By.name("telephoneno");
	By email = By.name("emailid");
	By password = By.name("password");
	By submitBtn = By.name("sub");
	
	//Action Mathods
	public void clickAddNewCustomer() {
		driver.findElement(addNewCustomerr).click();
		
	}
	public void CustomerName(String cName) {
		driver.findElement(CustomerName).sendKeys(cName);
	}
	public void CustomerGendeer(String cgender) {
		driver.findElement(gender).click();
	}
	public void CustomerDOB(String mm,String dd,String yy) {
		driver.findElement(Dob).sendKeys(mm);
		driver.findElement(Dob).sendKeys(dd);
		driver.findElement(Dob).sendKeys(yy);
	}
	public void CustomerAddress(String caddress) {
		driver.findElement(address).sendKeys(caddress);
		
	}
	public void CustomerCity(String ccity) {
		driver.findElement(city).sendKeys(ccity);
		
	}
	public void CustomerState(String cstate) {
		driver.findElement(state).sendKeys(cstate);
		
	}
	public void CustomerPinNo(String cpinno) {
		driver.findElement(pinno).sendKeys(cpinno);
		
	}
	public void CustomerTelephone(String ctelephone) {
		driver.findElement(telephone).sendKeys(ctelephone);
		
	}
	public void CustomerEmail(String cemail) {
		driver.findElement(email).sendKeys(cemail);
		
	}
	public void CustomerPassword(String cpassword) {
		driver.findElement(password).sendKeys(cpassword);
		
	}
	public void CustomerSubmitBtn() {
		driver.findElement(submitBtn).click();
		
	}
}
