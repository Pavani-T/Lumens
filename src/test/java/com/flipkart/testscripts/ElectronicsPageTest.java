package com.flipkart.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.constants.BaseClass;
import com.flipkart.design.ElectronicsPage;
import com.flipkart.design.FlightsPage;
import com.flipkart.design.SignInPage;

public class ElectronicsPageTest extends BaseClass {

	SignInPage si;
	ElectronicsPage ep;

	public ElectronicsPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		si = new SignInPage();
		ep= new ElectronicsPage();

	}

	@Test
	public void electronicsTest() throws Exception {

		si.signIn();
		ep.electronics();
	}

}
