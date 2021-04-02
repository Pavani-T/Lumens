package com.lumens.design;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lumens.constants.BaseClass;

public class ElectronicsPage extends BaseClass {
	//div[@class='_2Ze_a-']//a[@href='/travel/flights?param=DTNavIcon']
	@FindBy(xpath = "//div[@class='_2Ze_a-']//a[@href='/electronics-big-savings-days-store']")
	WebElement electronic;

	public ElectronicsPage() {

		PageFactory.initElements(driver, this);

	}

	public void electronics() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		electronic.click();

	}
}
