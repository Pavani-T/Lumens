package com.lumens.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumens.constants.BaseClass;
import com.lumens.design.CreateAccountPage;

public class CreateAccountPageTest extends BaseClass {

	CreateAccountPage cap;

	public CreateAccountPageTest() {

		super();
	}
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		initialization();
		cap = new CreateAccountPage();
	    Thread.sleep(2000);
	}
	
	@Test
	public void buttonClickTest() throws InterruptedException {
		cap.buttonClick();
	}

	@Test
	public void createAccountTest() {
		
		cap.createAccount();
	}
}
