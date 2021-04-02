package com.lumens.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumens.constants.BaseClass;
import com.lumens.design.LogoutPage;
import com.lumens.design.SignInPage;

public class LogutPageTest extends BaseClass{

	LogoutPage lp;
	//SignInPage si;
	
	public LogutPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		//si = new SignInPage();
		lp = new LogoutPage();
	}

	@Test
	public void logoutTest() throws Exception {
		
		//si.signIn();
		lp.logut();
	}
}
