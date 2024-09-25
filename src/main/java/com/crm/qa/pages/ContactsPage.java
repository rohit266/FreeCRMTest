package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//How to know about that you are on right page
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	
	//I am using this because after click on contacts button, some part of contacts page is hide behind the side bare
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement contactsFilter;
	
	@FindBy(xpath = "//button[contains(text(), 'Hide Filters')]")
	WebElement contactsUpdatedFilter;
	
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	WebElement createContactButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	
	
//	//We will use other way to manage all check boxes in table
//	@FindBy(xpath= "//a[contains(text(), 'Atul Kumar')]/parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")
//	WebElement contactChecbox;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this); //this means, we are initialize the all the webelements or objects which we have already declare
		
	}
	
	public String verifyContactsPageTitle() {
		return driver.getTitle(); //Cogmento CRM
	}
	
	//I am using this because after click on contacts button, some part of contacts page is hide behind the side bare
	public void VerifyShowFilterButton() {
		contactsFilter.click();
	}
	
	public boolean verifycontactLabel() {
		System.out.println("asserttrue Result" + contactsLabel.isDisplayed());
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]/parent::td"
				+ "//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
	}
	
	
	public void createNewContact(String ftName, String ltName, String email) {
		createContactButton.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emailAddress.sendKeys(email);
		saveBtn.click();
	}
	
	
}
