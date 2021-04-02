package com.lumens.design;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class SignInPage extends BaseClass {

	@FindBy(xpath = "//div[@class='value']/input[@name='dwfrm_login_username']")
	WebElement email;
	@FindBy(xpath = "//input[@name='dwfrm_login_password']")
	WebElement password;
	@FindBy(xpath = "//button[@name='dwfrm_login_login']")
	WebElement loginIn;

	// span[text()='Enter Email/Mobile number']
	public SignInPage() {

		PageFactory.initElements(driver, this);

	}

	public void signIn() throws InterruptedException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread.sleep(1000);
		email.sendKeys(prop.getProperty("email1"));
		password.sendKeys(prop.getProperty("password1"));
		loginIn.click();

	}

}
