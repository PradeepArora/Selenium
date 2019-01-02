package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory or OR
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	//Constructor
	public LoginPage() {
		PageFactory.initElements(driver,this);
		//this here is pointing to the current class object
		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validatePageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pd) throws IOException, InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pd);
		Thread.sleep(2000);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public void signUp() {
		signUpBtn.click();
	}
}
