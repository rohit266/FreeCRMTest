package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super(); //By the use of super() keyword, we directly call to the super class constructor (now it is calling TestBase.java class contructor)
		System.out.println("Performe changes by User 02");
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTiTleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
//	@Test(priority=2)
//	public void crmLogoImageTest() {
//		boolean flag = loginpage.validateCRMImage();
//		Assert.assertTrue(flag);
//	}
	
	
	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean homePageTitle = homepage.verifyCorrectUsername();
		Assert.assertEquals(homePageTitle, true, "User is not logged in!");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
