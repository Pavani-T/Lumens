package com.flipkart.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.constants.BaseClass;
import com.flipkart.design.SignInPage;

public class SignInPageTest extends BaseClass{
	
	SignInPage sp;

	public SignInPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		sp = new SignInPage();
	}

	@Test
	public void signinTest() throws Exception {
		
		sp.signIn();
	}
	
	

}
