package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPagTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName = "contacts";
	
	
	public ContactsPagTest(){
		super(); //By the user of super() keyword, we directly call to the super class constructor (now it is calling TestBase.java class contructor)
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		contactsPage = homepage.clickOnContactLink();
		contactsPage.VerifyShowFilterButton();
	}
	

	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		System.out.println("asserttrue Result" + contactsPage.verifycontactLabel());
		Assert.assertTrue(contactsPage.verifycontactLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSinglecontactsTest() {
		contactsPage.selectContactsByName("Atul Kumar");
	}
	
	
	@Test(priority=3)
	public void selectMultiplecontactsTest() {
		contactsPage.selectContactsByName("Atul Kumar");
		contactsPage.selectContactsByName("Sunita Pal");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String ftName, String ltName, String email) {
		//contactsPage.createNewContact("Ashu", "Gagan", "ashu123@yopmail.com");
		contactsPage.createNewContact(ftName, ltName, email);
	}
	
//	
//	@AfterMethod
//	public void tearDwon() {
//		driver.quit();
//	}
	
	
	
}
