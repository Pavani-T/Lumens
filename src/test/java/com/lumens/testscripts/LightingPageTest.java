package com.lumens.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumens.constants.BaseClass;
import com.lumens.design.LightingPage;
import com.lumens.design.SignInPage;

public class LightingPageTest extends BaseClass{

	
	LightingPage fp;
	SignInPage si;
	
	public LightingPageTest() {
		super();
	}
	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		si = new SignInPage();
		fp =  new LightingPage();
		
	}
	
	@Test
	public void lightPageTest() throws Exception {
		
		si.signIn();
		fp.clickOnLight();
	}
	
}
