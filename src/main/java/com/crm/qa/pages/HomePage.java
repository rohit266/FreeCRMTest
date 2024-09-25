package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(), 'Rohit Kumar')]")
	@CacheLookup 
//	 "@CacheLookup" is a annotation to store information in cache and for this it is storing user label name information cache
//	Whenever we interact with that element then it will get the particular element form cache instead of page
//	and speed of framework will improved and if we do not user @CacheLookup then every time when we call this element "userNameLabel"
//	it will interact with page
//	Problem:- If the page got refreshed then their is a possibility it will StailElementException
//	We will not use this for every elements.
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this); //this means, we are initialize the all the webelements or objects which we have already declare
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle(); //Cogmento CRM
	}
	
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink() {
		//Action class is used for mouse event.
		Actions action=new Actions(driver);
		//WebElement element = contactsLink;
		action.moveToElement(contactsLink).build().perform();
		contactsLink.click();
		return new ContactsPage(); //This is returning next landing page and next landing page is Contacts page
	}
	
	public DealsPage clickOnDealsLink() {
		//Action class is used for mouse event.
		Actions action=new Actions(driver);
		//WebElement element = contactsLink;
		action.moveToElement(dealsLink).build().perform();
		dealsLink.click();
		return new DealsPage(); //This is returning next landing page and next landing page is Deals page
	}
	
	
	public TasksPage clickOnTasksLink() {
		//Action class is used for mouse event.
		Actions action=new Actions(driver);
		//WebElement element = contactsLink;
		action.moveToElement(tasksLink).build().perform();
		tasksLink.click();
		return new TasksPage(); //This is returning next landing page and next landing page is Tasks page
	}
	
}
