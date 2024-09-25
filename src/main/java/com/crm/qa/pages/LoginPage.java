package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class, img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this); //this means, we are initialize the all the webelements or objects which we have already declare
		
	}	
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(); //This is returning next landing page and next landing page is Home page
	}
	
	
	
}
