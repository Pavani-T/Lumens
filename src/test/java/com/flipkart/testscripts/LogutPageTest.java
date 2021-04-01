package com.flipkart.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.design.LogoutPage;
import com.flipkart.design.SignInPage;
import com.flipkart.constants.BaseClass;

public class LogutPageTest extends BaseClass{

	LogoutPage lp;
	SignInPage si;
	
	public LogutPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		si = new SignInPage();
		lp = new LogoutPage();
	}

	@Test
	public void logoutTest() throws Exception {
		
		si.signIn();
		lp.logut();
	}
}
