package com.flipkart.design;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.constants.BaseClass;

public class FlightsPage extends BaseClass{
	//p[text()='Flights']
	//a[@class='_2A40On']//p[text()='Flights']
	
	@FindBy(xpath="//div[@class='_2Ze_a-']//a[@href='/travel/flights?param=DTNavIcon']") WebElement flight;
	
	public FlightsPage() {

		PageFactory.initElements(driver, this);
		
	}

	public void clickOnFlight() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flight.click();
		driver.navigate().back();
	}
	
}
