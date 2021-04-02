package com.lumens.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumens.constants.BaseClass;
import com.lumens.design.CreateAccountPage;
import com.lumens.design.LightingPage;
import com.lumens.design.LogoutPage;
import com.lumens.design.SignInPage;

public class SignInPageTest extends BaseClass{
	
	SignInPage sp;
	CreateAccountPage cp;
	LightingPage lp;
	LogoutPage lop;
	
	public SignInPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		cp = new CreateAccountPage();
		sp = new SignInPage();
		lp = new LightingPage();
		lop = new LogoutPage();
	}

	@Test
	public void signinTest() throws Exception {
		
		cp.buttonClick();
		sp.signIn();
		lp.clickOnLight();
		lop.logut();
		
	}
	
	

}
