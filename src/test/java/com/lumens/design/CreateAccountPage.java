package com.lumens.design;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class CreateAccountPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Account']")
	WebElement accountBtn;
	@FindBy(xpath = "//div[@class='customerInfo dropdown-item']//a[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "//button[@id='createAccountBtn']")
	WebElement createAccountBtn;
	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_emailconfirm']")
	WebElement emailConfirm;
	@FindBy(xpath = "//input[@name='dwfrm_profile_login_password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='dwfrm_profile_login_passwordconfirm']")
	WebElement confirmpassword;
	@FindBy(xpath = "//button[@class='medium']")
	WebElement createBtn;
	
	
	public CreateAccountPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void buttonClick() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(accountBtn).click().build().perform();
		//accountBtn.click();
		Thread.sleep(1000);
		signIn.click();
	}
	
	public void createAccount() {
		

		createAccountBtn.click();
		firstName.sendKeys(prop.getProperty("firstName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		email.sendKeys(prop.getProperty("email"));
		emailConfirm.sendKeys(prop.getProperty("emailConfirm"));
		password.sendKeys(prop.getProperty("password"));
		confirmpassword.sendKeys(prop.getProperty("confirmpassword"));
		createBtn.click();
		
	}
	
	
	
	
	

}
