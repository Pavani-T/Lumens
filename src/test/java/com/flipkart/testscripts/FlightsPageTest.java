package com.flipkart.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.constants.BaseClass;
import com.flipkart.design.FlightsPage;
import com.flipkart.design.SignInPage;

public class FlightsPageTest extends BaseClass{

	
	FlightsPage fp;
	SignInPage si;
	
	public FlightsPageTest() {
		super();
	}
	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		si = new SignInPage();
		fp =  new FlightsPage();
		
	}
	
	@Test
	public void flightPageTest() throws Exception {
		
		si.signIn();
		fp.clickOnFlight();
	}
	
}
