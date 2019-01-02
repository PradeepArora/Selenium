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

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		boolean b = homePage.verifyCorrectUserName();
		Assert.assertTrue(b);
	}

	@Test(priority = 3)
	public void contactsPageTest() throws IOException, InterruptedException {
		testutil.switchToFrame();
		homePage.clickOnContactsLink();
		
	}

	@Test(priority = 4)
	public void dealsPageTest() throws IOException {
		testutil.switchToFrame();
		homePage.clickOnDealsLink();
	}

	@Test(priority = 5)
	public void tasksPageTest() {
		testutil.switchToFrame();
		homePage.clickOnTasksLink();
	}

	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}

}
