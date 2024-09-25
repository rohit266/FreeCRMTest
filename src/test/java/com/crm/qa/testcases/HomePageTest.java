package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{

	//Use Ctrl+Shift+O for automatically perform import functionality.
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest(){
		super(); //By the user of super() keyword, we directly call to the super class constructor (now it is calling TestBase.java class constructor)
		System.out.println("Performe changes by User 01");
		System.out.println("Again changes Performe by User 01");
	}
	
	
	//test cases should be separated  -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage = homepage.clickOnContactLink();
	}
	
	@Test(priority=4)
	public void verifyDelasLinkTest() {
		dealsPage = homepage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void verifyTasksLinkTest() {
		tasksPage = homepage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDwon() {
		driver.quit();
	}
	
}
