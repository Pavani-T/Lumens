package com.lumens.testscripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumens.constants.BaseClass;
import com.lumens.design.ElectronicsPage;
import com.lumens.design.LightingPage;
import com.lumens.design.SignInPage;

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
