package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//div[contains(text(),'Jul')]")
	WebElement selectMonth;
	
	@FindBy(xpath="//span[contains(text(),'Year')]")
	WebElement year;
	
	@FindBy(xpath="//div[contains(text(),'1990')]")
	WebElement selectYear;
	
	@FindBy(xpath="//div[@id='s2id_layer_community']/a")
	WebElement religion;
	
	@FindBy(xpath="//div[contains(text(),'Hindu')]")
	WebElement selectReligion;
	
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
	
	
	
	
}
