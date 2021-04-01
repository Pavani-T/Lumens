package com.flipkart.design;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.constants.BaseClass;

public class SignInPage extends BaseClass{
	
	
	
	//@FindBy(xpath="//*[text()='Login']") WebElement loginBtn;
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']") WebElement phoneNumber;
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']") WebElement password;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']") WebElement login;
	//span[text()='Enter Email/Mobile number']
	public SignInPage() {

		PageFactory.initElements(driver, this);
		
	}
	public void signIn() throws InterruptedException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//loginBtn.click();
		/*createAccountBtn.click();
		name.sendKeys("Anu");*/
		Thread.sleep(1000);
		phoneNumber.sendKeys(prop.getProperty("phoneNumber"));
		password.sendKeys(prop.getProperty("password"));
		login.click();
		
	}
	
}
