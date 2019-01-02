package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		initialization();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();		
		contactsPage=homePage.clickOnContactsLink();

	}
	
	@Test
	public void verifyContactsPageLabel() throws IOException {
		
		
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts lebel is missing on the page");
		
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

}
}