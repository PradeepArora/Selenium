package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=4)
	public void pageurlTest() {
		String URL = loginPage.validatePageURL();
		Assert.assertEquals(URL, "https://www.freecrm.com/index.html");
	}

	@Test(priority=2)
	public void crmlogoImageTest() {
		boolean img = loginPage.validateCRMImage();
		Assert.assertTrue(img);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		try {
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=4,enabled=false)
	public void signUpTest() {
		loginPage.signUp();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
