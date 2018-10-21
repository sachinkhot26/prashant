package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;



public class RegisterPage extends TestBase{

	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(linkText="Sign Up Free")
	WebElement signUp;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password1")
	WebElement password;
	
	@FindBy(xpath="//div[@id='s2id_layer_postedby']/a")
	WebElement select;
	
	@FindBy(xpath="//div[contains(text(),'Self')]")
	WebElement postedFor;
	
	@FindBy(xpath="//input[@value='Male']")
	WebElement gender;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement next;
	
	@FindBy(name="first_name")
	WebElement fName;
	
	@FindBy(name="last_name")
	WebElement lName;
	
	@FindBy(xpath="//span[contains(text(),'Day')]")
	WebElement day;
	
	@FindBy(xpath="//div[contains(text(),'27')]")
	WebElement selectDay;
	//div[contains(text(),'27')]
	
	@FindBy(xpath="//span[contains(text(),'Month')]")
	WebElement month;
	
	@FindBy(xpath="//div[contains(text(),'Apr')]")
	WebElement selectMonth;
	
	@FindBy(xpath="//span[contains(text(),'Year')]")
	WebElement year;
	
	@FindBy(xpath="//div[contains(text(),'1990')]")
	WebElement selectYear;
	
	@FindBy(xpath="//div[@id='s2id_layer_community']/a")
	WebElement religion;
	
	@FindBy(xpath="//div[contains(text(),'Hindu')]")
	WebElement selectReligion;
	
	@FindBy(xpath="//div[@id='s2id_layer_mother_tongue_select']/a/span[1]")
	WebElement motherTounge;
	
	@FindBy(xpath="//a[@id='btnSubmit' and contains(text(),'Sign Up')]")
	WebElement btnsignUp;
	
	@FindBy(xpath="//input[@id='regionalSite']")
	WebElement domain;
	
	
	public RegisterPage(){
		
		PageFactory.initElements(driver, this);

	}
	
	public void register() throws InterruptedException {
		login.click();
		signUp.click();
		Thread.sleep(3000);
		email.sendKeys(prop.getProperty("email"));
		password.sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		select.click();
		postedFor.click();
		Thread.sleep(2000);
		gender.click();
		Thread.sleep(1000);
		next.click();
		
		
	}
	
	public void fillPersonalInfo() throws InterruptedException {
		
		fName.sendKeys("sachin");
		lName.sendKeys("K");
		day.click();
		selectDay.click();
		Thread.sleep(5000);
//		month.click();
//		Thread.sleep(2000);
		selectMonth.click();
		Thread.sleep(2000);
		//year.click();
		selectYear.click();
		Thread.sleep(2000);
		religion.click();
		selectReligion.click();
		System.out.println(motherTounge.getText());
		Thread.sleep(3000);
		//btnsignUp.click();
	}
	
	public void verifyLanguage(String language) {
		String actualLangauage=motherTounge.getText();
		String expectedLanguage=language;
		
		Assert.assertEquals(expectedLanguage, actualLangauage);
		btnsignUp.click();
		
	}
	
	public void verifyDomainPresent() {
		Assert.assertTrue(domain.isDisplayed());
	}
	
	
	
	
}
